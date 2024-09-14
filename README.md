# AI Demo

## Description

Demo project for Langchain4j library and Spring Boot integration.

Langchain4j is a Java library designed to facilitate the development of applications leveraging large language models (LLMs) and integrating natural language processing (NLP) capabilities. Inspired by the LangChain framework, which is popular in the Python ecosystem, Langchain4j aims to provide similar functionalities for the Java programming environment.

## Configuration

Contains configuration for:
* **locally hosted LLM (llama3.1)**: 
  * *'ollama'* Spring profile defined in *application-ollama.yml* file: 
    ```
    langchain4j:
      ollama:
        chat-model:
          model-name: llama3.1
          temperature: 0.2
          base-url: http://localhost:11434
          format: json
          timeout: 1200s
    ```
  * one can use *docker-dev/ollama/docker-compose.yml* file to run required PostgreSQL database with locally hosted llama3 LLM.

* **cloud-based ChatGPT 3.5**:
  * *'chatgpt'* Spring profile defined in *application-chatgpt.yml* file:
    ```
    langchain4j:
      open-ai:
        chat-model:
          api-key: ${OPEN_AI_API_KEY}
          model-name: gpt-3.5-turbo
          temperature: 0.2
          log-requests: true
          log-responses: true
          response-format: json_object
          timeout: 1200s
    ```
  * one can use *docker-dev/chatgpt/docker-compose.yml* file to run required PostgreSQL database.
  * one has to provide own Open AI API key exposed as *OPEN_AI_API_KEY* environmental variable.

## Implementation

### Interactions with LLM

Composition of the following annotations (`@AiService`, `@UserMessage` and `@SystemMessage`) makes it possible
to interact with the given LLM solution:

```
@AiService
public interface TankAiAssistant {

    @UserMessage("Give me information about tank with name {{tankName}}. Do not execute tool.")
    TankDTO describeTank(@V("tankName") String tankName);

    @UserMessage("Prepare concise and interesting summary about persisted tanks. " +
            "Summary should cover different aspects of tanks.")
    TankSummaryDTO summarizeTanks();

    @UserMessage("Identify names of best tanks for participating in storm (or front attack on densely defended positions) " +
            "within set of persisted tanks.")
    @SystemMessage("Storm tanks are characterized by huge gun and thick front armour.")
    TankNameListDTO identifyStormTanks();
}
```

The first method is used to scrap tank data from a chosen AI solution. Then, a set of persisted data (scrapped data is saved to the database by another service)
can be analyzed using two other methods. LLM can access the database data thanks to the `@Tool` annotation described in the next section.

### Giving LLM access to the codebase

It is possible to allow LLM to execute Java code using `@Tool` annotation. 

```
@Component
@RequiredArgsConstructor
public class TankTool {

    private final TankService tankService;

    @Tool("Get data of persisted tanks for summary and analysis.")
    public List<TankDTO> getPersistedTanksData() {
        return tankService.getAllTanks();
    }
}
```
In our example, LLM is able to fetch persisted tank data from database for performing further analysis.

## Usage

### Scrapping & persisting information from LLM

* To scrap new tank information from LLM and save data to database:
`PUT localhost:8080/tankInfo?tankName=PzVI TigerII`
![put-tankinfo.png](readme_img/put-tankinfo.png)

### Fetching persisted data
* To fetch scrapped data that were persisted in database:
`GET localhost:8080/tankInfo`
![get-tankinfo.png](readme_img/get-tankinfo.png)

### Analysis of persisted data
* To make LLM select name of storm tanks from the set of tanks persisted in database:
`GET localhost:8080/tankInfo/stormTanks`
![get-tankinfo-stormtanks.png](readme_img/get-tankinfo-stormtanks.png)
* To make LLM prepare short summary about the set of tanks persisted in database:
`GET localhost:8080/tankInfo/summary`
![get-tankinfo-summary.png](readme_img/get-tankinfo-summary.png)