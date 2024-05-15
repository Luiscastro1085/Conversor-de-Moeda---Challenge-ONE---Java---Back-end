import br.com.alura.Challenge.ApiKeyPackge.ApiKey;

import java.io.IOException;
import java.util.Scanner;

public class InterfacePrincipal extends ApiKey {

    public static void main(String[] args) throws IOException, InterruptedException {
        ApiKey apikey = new ApiKey();

        Double add;

        Scanner scanner = new Scanner(System.in);
        String moneyName;

        do {

            System.out.println("""
                    *******************************************************
                                        
                    Seja Bem-Vind@ ao Conversor de Moedas!
                    
                    Opções:
                                        
                    1) Dólar ==>> Peso Argentino
                    2) Peso Argentino ==>> Dólar
                    3) Dólar ==>> Real Brasileiro
                    4) Real Brasileiro ==>> Dólar
                    5) Dólar ==>> Peso Colombiano
                    6) Peso Colombiano ==>> Dólar
                    7) dirham ==>> Dólar
                    8) Sair
                                        
                    Digite uma opção válida:
                    *******************************************************
                    """);

            moneyName = scanner.next();

            if (moneyName.equals("8")) {
                System.out.println("Obrigado por usar nosso sistema Saindo.... ");
                break;
            }

            System.out.println("Qual o valor que você deseja converter?");

            long moneyValue = scanner.nextLong();

            switch (moneyName) {
                case "1":
                    apikey.httpRequest("USD", "ARS");
                    add = apikey.getJsonCoin().conversion_rate() * moneyValue;
                    System.out.println("Valor " + moneyValue + "[USD] corresponde ao valor final de =>>> " + add + "[ARS]");
                    break;
                case "2":
                    apikey.httpRequest("ARS", "USD");
                    add = apikey.getJsonCoin().conversion_rate() * moneyValue;
                    System.out.println("Valor " + moneyValue + "[ARS] corresponde ao valor final de =>>> " + add + "[USD]");
                    break;
                case "3":
                    apikey.httpRequest("USD", "BRL");
                    add = apikey.getJsonCoin().conversion_rate() * moneyValue;
                    System.out.println("Valor " + moneyValue + "[USD] corresponde ao valor final de =>>> " + add + "[BRL]");
                    break;
                case "4":
                    apikey.httpRequest("BRL", "USD");
                    add = apikey.getJsonCoin().conversion_rate() * moneyValue;
                    System.out.println("Valor " + moneyValue + "[BRL] corresponde ao valor final de =>>> " + add + "[USD]");
                    break;
                case "5":
                    apikey.httpRequest("USD", "COP");
                    add = apikey.getJsonCoin().conversion_rate() * moneyValue;
                    System.out.println("Valor " + moneyValue + "[USD] corresponde ao valor final de =>>> " + add + "[COP]");
                    break;
                case "6":
                    apikey.httpRequest("COP", "USD");
                    add = apikey.getJsonCoin().conversion_rate() * moneyValue;
                    System.out.println("Valor " + moneyValue + "[COP] corresponde ao valor final de =>>> " + add + "[USD]");
                    break;
                case "7":
                    apikey.httpRequest("AED", "USD");
                    add = apikey.getJsonCoin().conversion_rate() * moneyValue;
                    System.out.println("Valor " + moneyValue + "[AED] corresponde ao valor final de =>>> " + add + "[USD]");
                    break;
                default:
                    System.out.println("Digite uma opção valida: 1 ao 8");
                    break;
            }

        }while (true);

        }
    }
