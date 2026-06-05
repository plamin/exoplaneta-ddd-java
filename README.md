# Integrantes
Tomás Antonio Braga Cantuária       RM: 563295
Clara Barboza Costa       RM: 561490
Lucas Santana Silva       RM: 566261
Pedro Henrique Lamin Rodrigue   RM: 566379
Vinicius Alexandre Aureliano Ribeiro RM: 561606



# ExoScan - Análise de Habitabilidade de Exoplanetas

## Descrição

O ExoScan é um sistema de Gestão de exoplanetas desenvolvido em Java utilizando conceitos de Domain-Driven Design (DDD).

O sistema importa dados de exoplanetas a partir de um catálogo baseado em informações da NASA e permite a realização de análises para identificar potenciais candidatos habitáveis.

## Objetivo

Analisar exoplanetas e calcular um índice de habitabilidade com base em características como:

- Raio do planeta
- Período orbital
- Semi-eixo maior
- Temperatura da estrela hospedeira

## Estrutura DDD

### Entidades

* Exoplaneta
* EstrelaHospedeira

### Value Objects

* IndiceHabitabilidade
* TemperaturaEquilibrio
* ZonaHabitavel

### Domain Service

* HabitabilidadeScore

### Eventos de Domínio

* ExoplanetaCadastrado
* HabitabilidadeCalculada

### Repositórios

* ExoplanetaInterface
* ExoplanetasCatalogo

## Funcionalidades

* Importação de exoplanetas via CSV
* Consulta de exoplanetas por nome
* Cálculo do índice de habitabilidade
* Cadastro manual de novos exoplanetas

## Fonte dos Dados

Os dados utilizados no sistema são provenientes de catálogos públicos de exoplanetas disponibilizados pela NASA.
