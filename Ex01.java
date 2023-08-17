import java.util.HashMap;
import java.util.Map;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex01{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in); 

        int x = 0;

            System.out.println("Selecione um programa: ");

        do{
            System.out.println("(1)  Inverter array numerico.");
            System.out.println("(2)  Somar numeros vizinhos em um array.");
            System.out.println("(3)  Imprimir retangulo.");
            System.out.println("(4)  Inverter frase.");
            System.out.println("(5)  Montar cronograma de estudos.");
            System.out.println("(6)  Gerador numeros sorteio.");
            System.out.println("(7)  Multiplicacao por 11. ");
            System.out.println("(8)  Validador de Datas.");
            System.out.println("(9)  Validador Data x DiaDaSemana.");
            System.out.println("(10) Inverter array numerico - FILE. ");
            System.out.println("(11) Validador de Datas - FILE. ");
            System.out.println("(12) Inverter frase - FILE.");
            System.out.println("Finalizar a execução (0)");

            x = scan.nextInt();

         switch (x) {

                case 1:
                    switchArray(scan);
                    break;
                case 2:
                    sumNext(scan);
                    break;
                case 3:
                    imprimirRetangulo(5, 4, 'X');
                    break;
                case 4:
                    switchPhrase(scan);
                    break;
                case 5:
                    disciplinasTempo(scan);
                    break;
                case 6:
                    sorteioOrganizacao(scan);
                    break;
                case 7:
                    multiplicacaoPorOnze(scan);
                    break;
                case 8:
                    validacaoData(scan);
                    break;
                case 9:
                    validacaoDataEDiaDaSemana(scan);
                    break;
                case 10:
                     readVectorsFromFile();
                    break;
                case 11:
                    validDataFile();;
                    break;
                case 12:
                    switchPhraseFile();
                    break;
                default:
                    break;
            }
        } while (x != 0);
    }

    public static void switchPhraseFile(){
            try {
                Scanner fileScanner = new Scanner(new File("frases.txt"));
    
                while (fileScanner.hasNextLine()) {
                    String frase = fileScanner.nextLine();
                    if (frase.equalsIgnoreCase("fim")) {
                        break;
                    }
                    String fraseInvertida = inverterFrase(frase);
                    System.out.println("Frase invertida: " + fraseInvertida);
                }
    
                System.out.println("Programa encerrado.");
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado: " + e.getMessage());
              }
    }




    public static void validDataFile() {
        try {
            Scanner fileScanner = new Scanner(new File("datas.txt"));

            int numDatas = Integer.parseInt(fileScanner.nextLine());

            for (int i = 0; i < numDatas; i++) {
                String data = fileScanner.nextLine();
                if (validarData(data)) {
                    System.out.println("A data " + data + " é válida.");
                } else {
                    System.out.println("A data " + data + " é inválida.");
                }
            }

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
          }
    }

    




    public static void readVectorsFromFile() {
            try {
                Scanner fileScanner = new Scanner(new File("vetores.txt"));
    
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    String[] elements = line.split(";");
    
                    ArrayList<Integer> vetorDinamico = new ArrayList<>();
                    for (String element : elements) {
                        vetorDinamico.add(Integer.parseInt(element));
                    }
    
                    vetorDinamico = GetNeighbor(vetorDinamico);
    
                    for (int i = vetorDinamico.size() - 1; i >= 0; i--) {
                        int num = vetorDinamico.get(i);
                        if (i > 0) {
                            System.out.printf("%d - ", num);
                        } else {
                            System.out.printf("%d", num);
                        }
                    }
    
                    System.out.println();
                }
    
                fileScanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado: " + e.getMessage());
              }
        }
    

    public static void validacaoDataEDiaDaSemana( Scanner scanner) {
            String dataInput;
            do {
                System.out.print("Digite uma data no formato DD/MM/AAAA: ");
                dataInput = scanner.nextLine();
            } while (!validarData(dataInput));
    
            LocalDate data = LocalDate.parse(dataInput, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            DayOfWeek diaDaSemana = calcularDiaDaSemana(data);
    
            System.out.println("Em 2024, a data " + dataInput + " será um(a) " + translateDate(diaDaSemana));
    
            scanner.close();
        }

        public static DayOfWeek calcularDiaDaSemana(LocalDate data) {
            int dia = data.getDayOfMonth();
            int mes = data.getMonthValue();
            int ano = data.getYear();
    
            if (mes <= 2) {
                mes += 12;
                ano--;
            }
    
            int diaDaSemana = (dia + 2*(mes) + ((3*(mes*1))/5) + ano + ano/4 - ano/100 + ano / 400 + 2) % 7;
         
            
            // Ajuste para o calendário brasileiro onde domingo é 0 e sábado é 6
            if (diaDaSemana == 0) {
                return DayOfWeek.SUNDAY;
            } else {
                return DayOfWeek.of(diaDaSemana);
            }
        }
    
    
        public static String translateDate(DayOfWeek diaDaSemana) {
            switch (diaDaSemana) {
                case MONDAY:
                    return "segunda-feira";
                case TUESDAY:
                    return "terça-feira";
                case WEDNESDAY:
                    return "quarta-feira";
                case THURSDAY:
                    return "quinta-feira";
                case FRIDAY:
                    return "sexta-feira";
                case SATURDAY:
                    return "sábado";
                case SUNDAY:
                    return "domingo";
                default:
                    return "";
            }
        }



        public static void  validacaoData(Scanner scanner) {

            System.out.print("Digite uma data no formato DD/MM/AAAA: ");
            String data = scanner.nextLine();
    
            if (validarData(data)) {
                System.out.println("A data é válida.");
            } else {
                System.out.println("A data é inválida.");
            }
    
            scanner.close();
        }
    
        public static boolean validarData(String data) {
            String[] partes = data.split("/");
            if (partes.length != 3) {
                System.out.println("A data não está no formato correto (DD/MM/AAAA).");
                return false;
            }
    
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int ano = Integer.parseInt(partes[2]);
    
            if (ano < 1 || ano > 9999) {
                System.out.println("Ano inválido. Deve estar entre 0001 e 9999.");
                return false;
            }
    
            if (mes < 1 || mes > 12) {
                System.out.println("Mês inválido. Deve estar entre 01 e 12.");
                return false;
            }
    
            int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            
            if (ano % 400 == 0 || (ano % 4 == 0 && ano % 100 != 0)) {
                diasPorMes[2] = 29; // Ano bissexto, fevereiro tem 29 dias
            }
    
            if (dia < 1 || dia > diasPorMes[mes]) {
                System.out.println("Dia inválido para o mês informado.");
                return false;
            }
    
            return true;
        }
    
    





    public static void multiplicacaoPorOnze(Scanner scanner) {
        System.out.print("Digite um número de 2 dígitos: ");
            int numero = scanner.nextInt();

            int primeiroDigito = numero / 10;
            int segundoDigito = numero % 10;
            
            int produto = primeiroDigito + segundoDigito;
            if (produto > 9) {
                primeiroDigito += produto / 10;
                produto %= 10;
            }

            int novoNumero = (primeiroDigito * 100) + (produto * 10) + segundoDigito;

            System.out.println("Resultado da multiplicação por 11: " + novoNumero);

            scanner.close();
    }






    public static void  sorteioOrganizacao(Scanner scanner) {

            System.out.print("Digite o primeiro prêmio da loteria federal (6 dígitos): ");
            int primeiroPremio = scanner.nextInt();
    
            System.out.print("Digite o segundo prêmio da loteria federal (6 dígitos): ");
            int segundoPremio = scanner.nextInt();
    
            int tresPrimeirosDigitosSegundoPremio = segundoPremio / 1000;
            int tresUltimosDigitosPrimeiroPremio = primeiroPremio % 1000;
    
            int numeroVencedor = (tresPrimeirosDigitosSegundoPremio * 1000) + tresUltimosDigitosPrimeiroPremio;
    
            System.out.println("Número vencedor da organização: " + numeroVencedor);
    
            scanner.close();
    }
    
    public static void disciplinasTempo(Scanner scanner){

        System.out.print("Digite o tempo disponível para estudo (horas): ");
        int horasDisponiveis = scanner.nextInt();

        System.out.print("Digite o tempo disponível para estudo (minutos): ");
        int minutosDisponiveis = scanner.nextInt();

        System.out.print("Digite o número de disciplinas: ");
        int numDisciplinas = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Map<String, Integer> disciplinas = new HashMap<>();
        for (int i = 1; i <= numDisciplinas; i++) {
            System.out.print("Digite o nome da disciplina " + i + ": ");
            String nomeDisciplina = scanner.nextLine();
            disciplinas.put(nomeDisciplina, 0);
        }

        organizarPlanoDeEstudos(disciplinas, horasDisponiveis, minutosDisponiveis);

        scanner.close();
    }

    public static void organizarPlanoDeEstudos(Map<String, Integer> disciplinas, int horasTotal, int minutosTotal) {
        int totalMinutosDisponiveis = (horasTotal * 60) + minutosTotal;
        int numDisciplinas = disciplinas.size();
        int pausa = 20;

        int tempoPorDisciplina = (totalMinutosDisponiveis - (numDisciplinas - 1) * pausa) / numDisciplinas;

        System.out.println("Tempo de estudo por disciplina:");
        for (Map.Entry<String, Integer> entry : disciplinas.entrySet()) {
            String disciplina = entry.getKey();
            int horas = tempoPorDisciplina / 60;
            int minutos = tempoPorDisciplina % 60;

            System.out.println(disciplina + ": " + horas + " horas e " + minutos + " minutos");
        }

        System.out.println("Tempo de pausa entre disciplinas: " + pausa + " minutos");
        System.out.println("Tempo por disciplina: " + tempoPorDisciplina / 60 + " horas e " + (tempoPorDisciplina % 60) + " minutos");
    }


    public static void switchPhrase(Scanner scanner){
        String frase;
        do {
            System.out.print("Digite uma frase (ou 'fim' para encerrar): ");
            frase = scanner.nextLine();
            
            if (!frase.equalsIgnoreCase("fim")) {
                String fraseInvertida = inverterFrase(frase);
                System.out.println("Frase invertida: " + fraseInvertida);
            }
        } while (!frase.equalsIgnoreCase("fim"));

        System.out.println("Programa encerrado.");
        scanner.close();
    }

    public static String inverterFrase(String frase) {
        StringBuilder fraseInvertida = new StringBuilder();
        for (int i = frase.length() - 1; i >= 0; i--) {
            fraseInvertida.append(frase.charAt(i));
        }
        return fraseInvertida.toString();
    }

    public static void imprimirRetangulo(int largura, int altura, char caractere) {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                if (i == 0 || i == altura - 1 || j == 0 || j == largura - 1) {
                    System.out.print(caractere);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static void sumNext(Scanner scan){

        ArrayList<Integer> vetorDinamico = new ArrayList<>();

        int n = 0;

        // Adicionar elementos ao vetor
        System.out.println("A seguir insira valores de sua escolha no vetor, ao final digite 0 para concluir: ");

            System.out.printf("Insira o próximo valor, digite 0 caso tenha inserido todos os valores desejados: \t");
        while ((n = scan.nextInt()) != 0){
            vetorDinamico.add(n);
            System.out.printf("\n");
            System.out.printf("Insira o próximo valor, digite 0 caso tenha inserido todos os valores desejados: \t");
        }

       vetorDinamico = GetNeighbor(vetorDinamico);
       
        System.out.printf("\n");


        for (int i = vetorDinamico.size() - 1; i >= 0; i--) {
            int num = vetorDinamico.get(i);
            if (i>0){
                System.out.printf("%d - ", num);
            }else{
                System.out.printf("%d", num);
            }
        }

    }


    public static ArrayList<Integer> GetNeighbor(ArrayList <Integer> array){

        ArrayList<Integer> newVetor      = new ArrayList<>();

        for(int i=1; i<=array.size(); i++){
            newVetor.add(array.get((array.size())-i) + array.get((array.size())-(++i)));
        }

        if (array.size()%2 != 0){
            newVetor.add(array.get(((array.size())-1)+array.get((array.size())-1)));
        }

        return newVetor;
    }



    public static int[] switchArray(Scanner scan){
        int[] array = new int[6];

        for (int i = 0; i<6; i++){
            System.out.printf("Favor inserir um numero para a posi\u00E7ao %d do array: \t", i);
            array[i] = scan.nextInt();
        }
          
        int anterior = 0;
        int next = array.length - 1;
        
        while (anterior < next) {
            int temp = array[anterior];
            array[anterior] = array[next];
            array[next] = temp;
            System.out.printf(" - %d - ", array[anterior]);
            anterior++;
            next--;
        }

        for(int i = 0; i<array.length/2; i++){
            System.out.printf(" - %d -", array[(array.length/2)+(i)]);
        }
    
       scan.close();
       return array;
    }


    
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