# Exercícios de Threads com Semaforos - Sistemas Operacionais 1

<div align="center">
  
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)

</div>

## Sobre o projeto
Este projete contem a lista de exercícios de Threads com Semaforos, da materia de Sistemas Operacionais 1 do curso de Análise e desenvolvimento de sistemas da FATEC Zona Leste.<br>

## Índice
=================
<!--ts-->
* [Título](#exercícios-de-threads-com-semaforos---sistemas-operacionais-1)
* [Sobre o Projeto](#sobre-o-projeto)
* [Índice](#índice)
* [Exercícios](#exercícios)
* [Status do projeto](#status-do-projeto)
* [Tecnologias](#tecnologias)
* [Agradecimentos](#agradecimentos)
* [Autor](#autor)
<!--te-->

## Exercícios
1. Simular em Java: 4 cavaleiros caminham por um corredor, simultaneamente, de 2 a 4 m por 50 ms. O corredor é
escuro, tem 2 km e em 500 m, há uma única tocha. O cavaleiro que pegar a tocha, aumenta sua
velocidade, somando mais 2 m por 50 ms ao valor que já fazia. Em 1,5 km, existe uma pedra
brilhante. O cavaleiro que pegar a pedra, aumenta sua velocidade, somando mais 2 m por 50 ms
ao valor que já fazia. Ao final dos 2 km, abrem uma porta randômica km, os cavaleiros se separam
com 4 portas e, um por vez pega uma porta aleatória (que não pode repetir) e entra nela. Apenas
uma porta leva à saída. As outras 3 tem monstros que os devoram.

2. Um aeroporto tem 2 pistas (norte e sul) e, em cada pista, apenas um avião pode fazer a
decolagem. O procedimento de decolagem tem 4 fases ( taxiar, decolagem e afastamento da área).
A fase de manobra pode durar de 300 a 700 milissegundos A fase de taxiar, de 500 a 1000
milissegundos. A fase de decolagem, de 600 a 800 milissegundos. A fase de afastamento, de 300 a
800 milissegundos. O aeroporto reúne, por ciclo, 12 aeronaves que podem decolar pela pista norte
ou pela pista sul (decisão aleatória) mas, apenas 2 aviões podem circular pela área de decolagem
ao mesmo tempo. Fazer uma aplicação em Java que resolva o problema.

3. Numa prova de triatlo moderno, o circuito se dá da seguinte maneira:
  - 3Km de corrida onde os atletas correm entre 20 e 25 m / 30 ms
  - 3 tiros ao alvo com pontuação de 0 a 10
  - 5 km de ciclismo onde os atletas pedalam entre 30 e 40 m/ 40 ms
25 atletas participam da prova e largam juntos, no entanto, apenas 5 armas de tiro estão a
disposição. Cada atleta leva de 0,5 a 3s por tiro. Conforme os atletas finalizam o circuito de corrida,
em ordem de chegada, pegam a arma para fazer os disparos. Uma vez encerrados os disparos, a
arma é liberada para o próximo, e o atleta segue para pegar a bicicleta e continuar o circuito.

Para determinar o ranking final dos atletas, considera-se a seguinte regra:
  - O primeiro que chegar recebe 250 pontos, o segundo recebe 240, o terceiro recebe
  230, ... , o último recebe 10.
  - Soma-se à pontuação de cada atleta, o total de pontos obtidos nos 3 tiros (somados)
  Ordenar a pontuação e exibir o resultado final do maior pontuador para o menor.

## Status do projeto
  🚧Em construção 🚧 

* Projeto utiliza o padrão **MVC** *(Model View Controller)*, todos os arquivos estão dentro do diretório **src**
  * Dentro do pacote **view** está a camada de interacao direta com o usuario:
    * Na classe `Main`:
      * É criado um menu para escolha de qual exercício será executado:
        * Exercicio 1 -> É criado um `Semaphore`, com o número de permissões 1, o usuário vai escolher um número de 1 a 4, que será o atributo `portaEscolhida`, a única porta que leva a saída
        * Dentro de uma iteração `for` de 1 até 4 é criado uma instância da classe `CavaleiroController`, passando o `int i` do `for` como `idCavaleiro`, o `porta` como `portaEscolhida` e o `semaforo` como `Semaforo`
        * A `Thread` é iniciada pelo método `start()`
    
  * Dentro do pacote **controller** está a classe com métodos, que será instanciada na camada **view**:  
    * Na classe `CavaleiroController`:
    
      * Recebe um `int idCavaleiro`, além de um `Semaphore` que contera a quantidade de permissões, neste caso 1;
      * O método run vai verificar se a `DistanciaPercorrida` è menor que `distanciaCorredor`, se sim ele chama o método `caminhar`;
      <br>Em seguida verifica se o cavaleiro está no local exato da `tocha` e `pedraBrilhante`, caso não tenham sido pegas seus métodos são chamados;
      <br>Por fim, caso o cavaleiro tenha ultrapassado o `distanciaCorredor` o método `portaRandomica` é chamado;
      * O método `caminhar`, acrescenta a `distanciaPercorrida` o valor de `velocidadeCavaleiro` e mostra no terminal o quanto este cavaleiro percorreu;
      * O método `pegaPedraBrilhante` acrescenta 2 metros a `velocidadeCavaleiro` e associa o `idCavaleiro` que recebeu esse bonus, garantindo que nenhum outro receba
      * O método `pegaTocha` acrescenta 2 metros a `velocidadeCavaleiro`. e associa o `idCavaleiro` que recebeu esse bonus, garantindo que nenhum outro receba
      * O método `portaRandomica` utliza de um semaforo para garantir que apenas um cavaleiro entre na porta, `escolha` gera um número entre 1 - 4 que será a porta escolhida;
      <br>Escolhida a porta, o vetor estático `portas` recebe o `idCavaleiro` dentro do indice`[escolha - 1]`<br> é feita a verificação se a `escolha == portaEscolhida` se sim é mostrado no terminal que o cavaleiro chegou a saída, se não é mostrado no terminal que ele foi devorado por um monstro
    


## Tecnologias
- [Java](https://www.oracle.com/br/java/)
  - [Thread](https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html)
  - [Semaphore](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Semaphore.html)

## Agradecimentos
Agradeço ao professor da disciplina de Sistemas Operacionais 1, [Leandro Colevati dos Santos](https://www.leandrocolevati.com.br/index.jsp), por todo o aprendizado passado.

## Autor

<div align="center">
<a href="https://www.linkedin.com/in/thiago-antenor/">
<img style="border-radius: 50%;" src="https://avatars.githubusercontent.com/u/99970279?v=4" width="100px;" alt="foto do autor"/>
 <br />
 <sub><b>Thiago Silva Antenor</b></sub></a> <a href="https://www.linkedin.com/in/thiago-antenor/" title="Linkedin"> 🧑🏾‍💻</a>


Feito por Thiago Silva Antenor 👨🏾‍💻 Entre em contato!

[![Linkedin Badge](https://img.shields.io/badge/-Thiago-blue?style=flat-square&logo=Linkedin&logoColor=white&link=https://www.linkedin.com/in/thiago-antenor/)](https://www.linkedin.com/in/thiago-antenor/) 
[![Gmail Badge](https://img.shields.io/badge/-thiagoantenor31@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:thiagoantenor31.com)](mailto:thiagoantenor31.com)
</div>
