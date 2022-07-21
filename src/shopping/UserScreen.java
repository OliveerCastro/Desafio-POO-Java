package shopping;

import java.util.List;
import java.util.Scanner;

// Classe que gera um menu de opções para o usuário com métodos implementados da interface
public class UserScreen implements UserInterface{

  // Criando o carrinho de compras
  Cart cart = new Cart();

  List<Product> products = new Products().getProducts();

  // Opção do usuário
  private int opt = 0;

  // Construtor que inicia o menu
  public UserScreen(){
    menu();
  }

  // Método de opções iniciais do menu
  @Override
  public void startScreen() {
        
    System.out.println("1 - Menu de produtos");
    System.out.println("2 - Itens no carrinho");
    System.out.println("3 - Quantidade de itens no carrinho");
    System.out.println("4 - Listar preços do carrinho");
    System.out.println("5 - Preço total do carrinho");
    System.out.println("0 - Sair");
        
  }

  // Método de opções para adicinar e remover produtos do carrinho
  @Override
  public void productsMenu() {
        
    System.out.println("1 - Adicionar produto ao carrinho");
    System.out.println("2 - Remover produto do carrinho");
    System.out.println("0 - Sair");
        
  }

  // Iniciando a interface de usuário com as opções de menu
  @Override
  public void menu(){

    do{
      // Renderiza o menu inicial
      startScreen();

      // Pega opção do usuárop pelo teclado
      getUserInput();
    
      // Selecioda de acordo com a opção do usuário
      try {

        switch (opt) {
          case 1:
    
            // Lista de produtos em estoque
            displayProducts();
    
            // Menu de produtos para adicionar ou remover do carrinho
            productsMenu();
    
            //opção do usuário
            getUserInput();
    
            // Mostra o menu de opções para o usuário
            subMenu();
            break;
          
          case 2:
            // Mostra lista de produtos no carrinho
            showCart();
            break;
          
          case 3:
            showCartQuantity();
            break;

          case 4:
            showCartPrices();
            break;

          case 5:
            showCartTotalPrice();
            break;

         case 0:
            //Saindo fora
            System.out.println("Bye!");
            System.exit(0);
            break;
            
          default:
              //Lançando uma exceção de opção inválida
              throw new OptionException("Opcao invalida");
        }
      } catch (Exception e) {
          System.out.println(e.getMessage());
        }
            
    } while(opt != 0);
        
  }


  // Menu de produtos para adicionar ou remover do carrinho
  private void subMenu() {

    try {
      switch (opt) {
        case 1:
          addProductToCart();
          showCart();
          break;
        case 2:
          removeProductFromCart();
          break;
        default:
          //Lançando exceção de opção inválida
          throw new OptionException("Opcao invalida");
      }
    } catch (Exception e) {
        System.out.println(e.getMessage());
      }

        
  }

  // Exibindo a lista de produtos em estoque
  @Override
  public void displayProducts() {

    for (Product prod: products) {
      System.out.println("Id do produto: " + prod.getId());
      System.out.println("Nome do produto: " + prod.getName());
      System.out.println("Marca do produto: " + prod.getBrand());
      System.out.println("Descricao do produto: " + prod.getDescription());
      System.out.println("Preco do produto: " + prod.getPrice());
      System.out.println();
      
      System.out.println();
    }
        
  }

  // Método para pegar a opção do usuáro pelo teclado
  @Override
  public int getUserInput() {

    System.out.println("Sua opcao:");
    Scanner scanner = new Scanner(System.in);
    
    opt = Integer.parseInt(scanner.nextLine());
    
    return opt;
        
  }

  // Método para adicionar um produto ao carrinho pelo id
  public void addProductToCart(){

    int id = getUserInput();
    
    try {
            
      if (id >= products.size()) {
          throw new ProductNotFoundException("Produto nao encontrado");
      } else {
          cart.addProduct(id);
      }

    } catch (Exception e) {
        System.out.println(e.getMessage());
      }

  }

  // Listando o carrinho
  public void showCart(){

     System.out.println(" -> Itens do carrinho:");

     cart.printCart();
    }

  // Quantidade de itens do carrinho
  private void showCartQuantity() {
      System.out.println(" -> Total de itens no carrinho");
      cart.itemsCount();
  }

    
  private void showCartTotalPrice() {
      System.out.println(" -> Valor total do carrinho");
      cart.getCartTotalPrice();
  }

  // Apresentando lista de preços do carrinho
  private void showCartPrices() {
      System.out.println(" -> Lista de preços do carrinho: ");
      cart.listCartPrices();
    }


  // Exclui um produto do carrinho
  public void removeProductFromCart(){

     int id = getUserInput();
    cart.removeProduct(id);

  }
    
}