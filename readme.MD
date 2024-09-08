# Mythspire Game Engine

Mythspire é uma game engine desenvolvida em Java, projetada para facilitar a criação de jogos 2D com um foco em RPGs clássicos. Este repositório contém a implementação da engine, incluindo a manipulação de mapas, entidades, animações e colisões.

## Sumário

- [Descrição do Projeto](#descrição-do-projeto)
- [Funcionalidades](#funcionalidades)
- [Arquitetura](#arquitetura)
- [Configuração do Ambiente](#configuração-do-ambiente)
- [Como Usar](#como-usar)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Dependências](#dependências)
- [Contribuindo](#contribuindo)
- [Licença](#licença)

## Descrição do Projeto

Mythspire é uma engine de jogo que fornece a base para criar jogos 2D em Java. O foco principal está em RPGs, oferecendo funcionalidades como gerenciamento de mapas, controle de entidades e animações, e verificação de colisões.

## Funcionalidades

- **Gerenciamento de Mapas**: Carregamento e renderização de mapas a partir de arquivos de texto.
- **Controle de Entidades**: Movimento e controle de entidades jogáveis com suporte a animações.
- **Animações**: Suporte para animações baseadas em sprites.
- **Colisões**: Verificação de colisões entre entidades e tiles do mapa.
- **Entrada do Teclado**: Gerenciamento de entradas de teclado para controle de entidades.

## Arquitetura

A arquitetura da engine é dividida em várias camadas e componentes principais:

- **Contexto do Jogo**: Gerencia o estado global do jogo e fornece acesso a componentes como o jogador e o mapa.
- **Mapa**: Representa o mapa do jogo e gerencia a renderização dos tiles.
- **Entidades**: Representa entidades no jogo, como o jogador, e gerencia seu comportamento e animações.
- **Animações**: Gerencia animações de entidades baseadas em sprites.
- **Colisões**: Verifica colisões entre entidades e tiles do mapa.
- **Entrada**: Gerencia a entrada do teclado para controle de entidades.

## Configuração do Ambiente

Para configurar o ambiente de desenvolvimento, siga as instruções abaixo:

1. **Clone o Repositório**

   ```sh
   git clone https://github.com/SEU_USUARIO/mythspire.git
   cd mythspire
2. **Configure o Maven**

Certifique-se de ter o Maven instalado. Você pode baixar o Maven aqui.

3. **Compile e Construa o Projeto**

   ```sh
   mvn clean install


## Como Usar
Para usar a engine, você pode criar um projeto que importe a biblioteca mythspire e utilize suas classes e métodos para criar e gerenciar seu jogo. Consulte a documentação da API para obter detalhes sobre como usar os diferentes componentes da engine.

Exemplo de Uso:

```java
    import br.com.leonardo.context.GameContext;
    import br.com.leonardo.context.GameContextSingleton;
    import br.com.leonardo.entity.Player;
    import br.com.leonardo.keys.KeyHandler;
    import br.com.leonardo.map.Map;
    
    public class Game {
        public static void main(String[] args) {
            GameContext gameContext = GameContextSingleton.getInstance();
            KeyHandler keyHandler = new KeyHandler();
            Player player = new Player(keyHandler);
    
            Map map = new Map("path/to/map/file.txt");
            gameContext.setMap(map);
            gameContext.setPlayer(player);
    
            // Inicie o loop principal do jogo
        }
    }
```

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

 - **src/main/java/br/com/leonardo**: Código fonte da engine.
   - **context**: Gerencia o contexto global do jogo.
   - **entity**: Representa entidades no jogo.
   - **map**: Gerencia mapas e tiles.
   - **service**: Serviços auxiliares como carregamento de recursos.
   - **config**: Configurações e carregamento de configurações.
   - **keys**: Gerencia a entrada do teclado.
   - **entity/animation**: Gerencia animações de entidades.
   - **entity/collision**: Verifica colisões entre entidades e tiles.
 - **src/main/resources**: Recursos do projeto, como imagens e arquivos de configuração.

## Dependências

O projeto utiliza as seguintes dependências:

 - **Lombok**: Biblioteca para reduzir a boilerplate code.
 - **Jackson**: Dataformat YAML: Para leitura de arquivos YAML.
 - **SLF4J**: Interface para logging.
 - **Logback**: Implementação de logging.
