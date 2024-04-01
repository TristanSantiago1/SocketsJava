import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

    public static void main(String[] args){

        int PUERTO = 9000;
        try {
            ServerSocket socket = new ServerSocket(PUERTO);
            System.out.println("Servidor escuchando en el puerto: " + PUERTO + "...");
            Socket conexion = socket.accept();
            
            PrintWriter outWay = new PrintWriter(conexion.getOutputStream(), true);
            BufferedReader inWay = new BufferedReader(new InputStreamReader(conexion.getInputStream()));

            outWay.println("Hola");
            outWay.println("Mundo,");
            outWay.println(" Tristan Eduardo Suarez Santiago");
            outWay.println("Dede el servidor!");
            Scanner scanner = new Scanner(System.in);
            String lineaIngresada;
            while(!(lineaIngresada = scanner.nextLine()).equalsIgnoreCase("Adios")){
                outWay.println(lineaIngresada);
            }
            outWay.println(lineaIngresada);
            System.out.println("Cliente: " + inWay.readLine());

            outWay.close();
            inWay.close();
            conexion.close();
            socket.close();

        } catch(IOException ex){
            System.out.println(ex);
        }
    }
}