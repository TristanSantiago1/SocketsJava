import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Cliente{  

    public static void main(String[] args){
        int PUERTO = 9000;
        try{
        Socket socket = new Socket("localhost", PUERTO);
        PrintWriter outWay = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader inWay = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String linearRecibida;
        while(!(linearRecibida = inWay.readLine()).equalsIgnoreCase("Adios")){
            System.out.println("Servidor: " + linearRecibida);
        }

        outWay.println("Recepcion de datos correcta....");

        outWay.close();
        inWay.close();
        socket.close();
    

        } catch (IOException ex){
            System.out.println(ex);
        }
    }
}