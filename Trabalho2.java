import javax.swing.*;
public class Trabalho2{
        static final int TAMANHO = 12;
        static Art Art[] = new Art[TAMANHO];
        static int somaMusicas;
        static int musicaPedida;
        
 
        static class Art {
                String musica;
                String artista;
                String compartimento;
                int numeroVezes;
        }
 
        public static void initializer() {
                for(int i=0; i<TAMANHO; i++){
                        Art[i] = new Art();
                }
 
        Art[0].compartimento = "101";
        Art[1].compartimento = "102";
        Art[2].compartimento = "102";
        Art[3].compartimento = "201";
        Art[4].compartimento = "202";
        Art[5].compartimento = "203";
        Art[6].compartimento = "301";
        Art[7].compartimento = "302";
        Art[8].compartimento = "303";
        Art[9].compartimento = "401";
        Art[10].compartimento = "402";
        Art[11].compartimento = "403";
 
        Art[0].artista = "Kanye West";
        Art[1].artista = "Kanye West";
        Art[2].artista = "alt-J";
        Art[3].artista = "alt-J";
        Art[4].artista = "alt-J";
        Art[5].artista = "Arctic Monkeys";
        Art[6].artista = "Arctic Monkeys";
        Art[7].artista = "Arctic Monkeys";
        Art[8].artista = "Arctic Monkeys";
        Art[9].artista = "Ben Howard";
        Art[10].artista = "The Bots";
        Art[11].artista = "The Bots";
 
        Art[0].musica = "Wolves";
        Art[1].musica = "FHL";
        Art[2].musica = "Breezeblocks";
        Art[3].musica = "Tessellate";
        Art[4].musica = "Bloodflood";
        Art[5].musica = "Fluorescent Adolescent";
        Art[6].musica = "Mardy Bum";
        Art[7].musica = "Riot Van";
        Art[8].musica = "When The Sun Goes Down";
        Art[9].musica = "Keep Your Head Up";
        Art[10].musica = "All I Really Want";
        Art[11].musica = "Ethipia";
        }
 
// 1) (PROCEDIMENTO e passagem de parâmetro por REFERÊNCIA)
//Solicite ao usuário o número de vezes que a música foi pedida(TOCADA), a mensagem que aparece para o usuário deve seguir o seguinte modelo:
//"Olá, insira o número de vezes que a música (Nome da Música) de (Nome do Artista) foi pedida nesta JUKEBOX: "
//Os campos entre parênteses devem ser substituídos pelos respectivos nomes cadastrados previamente.
        public static void questionOne() {
                for(int i=0; i<TAMANHO; i++) {
                        Art[i].numeroVezes = Integer.parseInt(JOptionPane.showInputDialog("Olá, insira o número de vezes que a música " + Art[i].musica + " de " + Art[i].artista + " foi pedida nesta JUKEBOX: "));
                }
        }  
 
 
//2) (FUNÇÃO e passagem de parâmetro por VALOR) Solicite ao usuário que informe um nome
// de um dos artista (STRING) e utilizando PESQUISA LINEAR mostre o número de músicas que
// este artista possui cadastrado no sistema da JUKEBOX.
 
        public static int questionTwo(String nome) {
        	int flag = 0;
                for(int i=0; i<TAMANHO; i++) {
                        if(Art[i].artista.equalsIgnoreCase(nome)){
                                flag = 1;
                                somaMusicas = somaMusicas + 1;
                        }
                }
                return somaMusicas;
        }
 
// 3) (FUNÇÃO e passagem de parâmetro por VALOR) Mostre quantas vezes a máquina tocou
// músicas. Como cada música custa a moeda de R$ 1,00 , o dono deseja saber quantos reais tem
// em caixa.
      
             public static int questionThree(int valor) {
                     for(int i=0; i<TAMANHO; i++){
                             valor = valor + Art[i].numeroVezes;
                     }
      
                     musicaPedida = valor;
                     return musicaPedida;
             }
         
// 4) (FUNÇÃO e passagem de parâmetro por VALOR) Mostre o nome do artista, o número do
// compartimento e a música MAIS PEDIDA.
           
           
              public static String questionFour(int Maior) {
                          String nomeArtista = "";
                          String nomeMusica = "";
                          String compartimentoNumero = "";
                          String message;
                          for(int i=0; i<TAMANHO; i++) {
                                  if(Art[i].numeroVezes > Maior) {
                                          nomeArtista = Art[i].artista;
                                          nomeMusica = Art[i].musica;
                                          Maior = Art[i].numeroVezes;
                                          compartimentoNumero = Art[i].compartimento;
                                  }
                          }
                          message = "O nome do artista é: " + nomeArtista +
                                     "\n" + "O número do compartimento é: " + compartimentoNumero +
                                     "\n" + "E a musica mais pedida é: " + nomeMusica;
                          return message;
                  }
              
              // 5) (FUNÇÃO e passagem de parâmetro por VALOR) Mostre o número do compartimento e o nome do artista da música MENOS pedida.
              
              
              public static String questionFive(int Menor) {
                      String message;
                      String artistName = "";
                      String musicName = "";
                      String compartmentNumber = "";
       
                      for (int i=0; i<TAMANHO; i++) {
                          if (Art[i].numeroVezes < Menor) {
                              artistName = Art[i].artista;
                              musicName = Art[i].musica;
                              Menor = Art[i].numeroVezes;
                              compartmentNumber = Art[i].compartimento;
                             
                          }
       
                      }
       
                      message = "O nome do artista é: " + artistName + "\n" + "O número do compartimento é: " + compartmentNumber + "\n" + "E a música menos pedida é: " + musicName;
                      return message;
       
              }
              
              
        public static void main (String [] args) {
 
                initializer();
                questionOne();
                String nome = JOptionPane.showInputDialog("Digite o nome do artista desejado: ");
                questionTwo(nome);
                
                if(somaMusicas >= 1) {
                	JOptionPane.showMessageDialog(null, "O artista " + nome + " possui " + somaMusicas + " músicas cadastradas.");
                }else{
                	JOptionPane.showMessageDialog(null, "O artista " + nome + " não foi encontrado.");
                }
                
                questionThree(musicaPedida);
                JOptionPane.showMessageDialog(null, "A maquina tocou " + musicaPedida + " músicas. Tem " + musicaPedida + " reais em caixa.");
                
                JOptionPane.showMessageDialog(null, questionFour(somaMusicas));
                JOptionPane.showMessageDialog(null, questionFive(somaMusicas));


            }
    }