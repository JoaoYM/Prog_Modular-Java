package src.Teorica;

public class Exercicios {
       
/*
TEÓRICOS
13 – O que é um método em um código de um sistema de informação?
    Por definição um método pode ser entendido como sendo uma função ou procedimento cuja finalidade é executar uma ação específica ou um conjunto de ações 
    dentro do contexto de um programa. Utilizando do conceito de blocos podemos modularizá-los, reutilizá-los e melhor organizá-los.

14 – Por que é aconselhável dividir sistemas em métodos separados uns dos outros?
    Essa prática é aconselhável, pois facilita a manutenção e legibilidade do código. Além disso, possibilita o reuso de métodos que possuem uma natureza generalista para a solução de problemas comuns.

15 – Defina o que é um parâmetro utilizado em um método Java. Depois de definir, explique por que é importante termos
parâmetros em métodos.
    Dentre os principais benefícios da parametrização de métodos podemos citar a reciclagem de código, flexibilidade, modularidade, abstração, personalização e eficiência. Sendo importante destacar que
a abstração presente nessa prática possibilita maior segurança no processo de manipulação do código, pois os detalhes do seu funcionamento ficam em segundo plano.

16 – O que acontece com um dado passado por parâmetro para um método após a execução deste método?
    Quando o parâmetro em questão se limita ao scopo do método as alterações ali nele efetuadas não terão influência no valor originalmente definido e presente fora do método, porém ao estabelecermos uma
relação objetos x referências as alterações realizadas nesse parâmetro irão refletir também fora do método. 

17 – Para cada situação abaixo, cite estruturas de dados que você utilizaria em sistemas de informação que precisam
destes dados para resolver o problema. Observe o exemplo para dar suas respostas:
EXEMPLO: Um praticante realiza uma série de exercícios em sua academia a cada dia da semana.
RESP: Cada entidade praticante pode ter um vetor ou lista estática com os dias da semana (que é um dado conhecido e
imutável). Cada dia da semana conterá uma fila de exercícios a serem feitos, assumindo que a ordem deles é
importante.
b) Uma oficina mecânica realiza diversos serviços em automóveis. Cada automóvel pode ter recebido muitos serviços ao
longo de sua existência. Um automóvel está sempre associado a um proprietário, que pode ser pessoa física ou jurídica
(empresa).
c) Um candidato possui uma série de habilidades para se candidatar a vagas de emprego. Cada vaga tem suas
habilidades específicas exigidas e deve possuir um conjunto de candidatos hábeis, destacando aquele que for mais
adequado para a vaga no momento.
d) Um posto de saúde atende a milhares de pacientes. O posto tem um calendário anual de vacinação e cada paciente
possui um prontuário com as vacinas tomadas, incluindo seu nome, lote e data de aplicação.


b) Em uma Oficina Mecânica, nós podemos usar a seguinte estrutura de dados:

- Cada automóvel pode ser representado como um objeto, com campos como marca, modelo, ano, proprietário, e uma lista de serviços realizados.
- Cada serviço realizado pode ser representado como um objeto, com detalhes como tipo de serviço, data, peças usadas, etc.
- Podemos armazenar os automóveis em um HashMap, onde a chave é a placa do veículo e o valor é o objeto representando o automóvel.
- Os proprietários (pessoas físicas ou jurídicas) podem ser armazenados em outra estrutura, talvez uma lista de proprietários, onde cada proprietário possui informações relevantes.

c) Ao lidar com Vagas de Emprego e Candidatos, nós podemos usar a seguinte estrutura de dados:

- Cada candidato pode ser representado como um objeto, com informações sobre suas habilidades, experiências, etc.
- Cada vaga de emprego também pode ser representada como um objeto, com detalhes como título, descrição, habilidades exigidas, etc.
- Podemos utilizar uma lista de candidatos para cada vaga, onde cada candidato é associado a uma pontuação baseada na correspondência de suas habilidades com as habilidades exigidas para a vaga.
- Podemos escolher o candidato mais adequado para a vaga com base em sua pontuação.

d) Em um Posto de Saúde, nós podemos usar a seguinte estrutura de dados:

- Cada paciente pode ser representado como um objeto, com informações pessoais e um histórico de vacinação.
- Cada vacina administrada pode ser representada como um objeto, com detalhes como nome da vacina, lote, data de aplicação, etc.
- Podemos utilizar um HashMap onde a chave é o nome do paciente (ou um identificador único) e o valor é o objeto que representa o paciente.
- O calendário anual de vacinação pode ser uma estrutura de dados separada, talvez um vetor ou lista com as datas e as vacinas agendadas.
 */
}
