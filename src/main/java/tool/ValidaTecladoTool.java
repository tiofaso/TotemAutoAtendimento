package tool;

public class ValidaTecladoTool {
    public Boolean tecladoValidoPrincipal(Integer input){
        if(input == null) {
            System.out.println("AVISO! Formato inválido, para escolher o item, você deve informar o número dele!");
            return false;
        }else if(input != 1 && input != 2) {
            System.out.println("AVISO! Opção inválida, tente novamente!");
            return false;
        }else {
            return true;
        }
    }
}
