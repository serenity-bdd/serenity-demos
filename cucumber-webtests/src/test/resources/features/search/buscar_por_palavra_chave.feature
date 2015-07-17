# language: pt
@component:ui
@version:Sprint-7
Funcionalidade: Buscar por palavra chave
  Para os compradores encontrarem o que estão procurando de forma mais eficiente
  Como um vendedor
  Desejo que os compradores possam buscar por artigos utilizando palavras chave

  Cenário: Buscar artigos por palavra chave
    Dado que quero comprar um cachecol de lã
    Quando eu buscar por 'wool'
    Então devo ver apenas artigos relacionados com 'wool'

  Cenário: Buscar por nome da loja
    Dado que desejo visualizar artigos de uma loja em particular
    Quando eu buscar uma loja por 'docksmith'
    Então devo encontrar 1 loja chamada 'docksmith'

  Delineação do Cenário: Buscar por muitos artigos utilizando palavra chave
    Dado que quero comprar um <article>
    Quando eu buscar por '<article>'
    Então devo ver apenas artigos relacionados com '<keyword>'
    Exemplos:
      | article      | keyword |
      | wool scarf   | wool    |
      | cotton shirt | cotton  |