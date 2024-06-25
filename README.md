# AI Demo

## Description

Demo project for Langchain4j library and Spring Boot integration.

Langchain4j is a Java library designed to facilitate the development of applications leveraging large language models (LLMs) and integrating natural language processing (NLP) capabilities. Inspired by the LangChain framework, which is popular in the Python ecosystem, Langchain4j aims to provide similar functionalities for the Java programming environment.

## Configuration

Contains configuration for locally hosted LLM (llama3) and cloud based ChatGPT 3.5.
In case of latter, one has to provide own Open AI API key.

## Usage

### Scrapping & persisting information from LLM

* To scrap new tank information from LLM and save data to in-memory (H2) db:
`PUT localhost:8080/tankInfo?tankName=PzVI TigerII`
![put-tankinfo.png](readme_img/put-tankinfo.png)

### Fetching persisted data
* To fetch scrapped data that were persisted in db:
`GET localhost:8080/tankInfo`
![get-tankinfo.png](readme_img/get-tankinfo.png)

### Analysis of persisted data
* To make LLM select name of storm tanks from the set of tanks persisted in db:
`GET localhost:8080/tankInfo/stormTanks`
![get-tankinfo-stormtanks.png](readme_img/get-tankinfo-stormtanks.png)
* To make LLM prepare short summary about the set of tanks persisted in db:
`GET localhost:8080/tankInfo/summary`
![get-tankinfo-summary.png](readme_img/get-tankinfo-summary.png)