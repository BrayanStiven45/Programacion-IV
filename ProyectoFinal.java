/* 
    Universidad Tecnológica de Perira
    Programa de Ingeniería de Sistemas y Computación
    Programación IV
    Estudiante: Brayan Stiven Valencia Ospina
    Código: 1112298468
    Profesor: Gustavo Adolfo Castañeda Trejos
 */



import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class ProyectoFinal{
    // Creacion de las varibles globales
    public static Scanner leerDatoTeclado = new Scanner (System.in ) ;
    public static final List<String[]> clientes = new ArrayList<>();
    
    public static final byte TIPO_INDENTIFICACION = 0;
    public static final byte DOUCUMENTO_INDENTIFICACION = 1;
    public static final byte NOMBRES = 2;
    public static final byte APELLIDOS = 3;
    public static final byte CORREO_ELECTRONICO = 4;
    public static final byte DIRECCION_RESIDENCIA = 5;
    public static final byte CIUDAD_RESIDENCIA = 6;
    public static final byte TELEFONO_CONTACTO = 7;
    public static final byte CONTRESEÑA = 8;
    

    // Metodo que muestra el menú de opciones
    public static void menu(){

        System.out.println("Bienvenido a MyHotel...");
        System.out.println("Mas que un lugar para descansar.");
        System.out.println("____________________________________\n");

        System.out.println("Ingrese la opción deseada.");
        System.out.println("1. Registrarse como cliente.");
        System.out.println("2. Iniciar Sesión.");
        System.out.println("3. Salir");

    }

    // Metodo que registra a los usuarios reciviendo los datos de ingresados por el usuario
    public static void registrarUsuario(String tipoIdentificacion,String documentoIdentificaion, String nombres, String apellidos, String correoElectronico, String direccionResidencia, String ciudadResidencia, String telefonoContacto, String contraseña){
        
        String[] cliente = new String[9];
        
        cliente[TIPO_INDENTIFICACION] = tipoIdentificacion;
        cliente[DOUCUMENTO_INDENTIFICACION] = documentoIdentificaion;
        cliente[NOMBRES] = nombres;
        cliente[APELLIDOS] = apellidos;
        cliente[CORREO_ELECTRONICO] = correoElectronico;    
        cliente[DIRECCION_RESIDENCIA] = direccionResidencia;
        cliente[CIUDAD_RESIDENCIA] = ciudadResidencia;
        cliente[TELEFONO_CONTACTO] = telefonoContacto;
        cliente[CONTRESEÑA] = contraseña;
        
        clientes.add(cliente);
    }

    // Metodo que solicita la contraseña a crear por el usurio y auntentica dos veces la contraseña
    public static String solicitarContraseña(){
        String contraseña = new String();
        String confirmarContraseña = new String();
        boolean contraseñaValida = false;

        while(!contraseñaValida){
            System.out.println("Digite su contraseña: ");
            contraseña = leerDatoTeclado.nextLine();
            System.out.println("Confirme su contraseña: ");
            confirmarContraseña = leerDatoTeclado.nextLine();
            if (contraseña.equals(confirmarContraseña)){
                contraseñaValida = true;
            } else {
                System.out.println("Las contraseñas no coinciden. Por favor intentelo de nuevo.");
            }
        }    
        return contraseña;
    }

    // Metodo que solicita los datos de registro al usuario y llama al metodo registrarUsuario
    public static void solicitarDatosDeRegistro(){
        System.out.println("____________________________________");
        System.out.println("Formulario de registro.");
        System.out.println("Para completar el registro, por favor facilitar la siguiente infomación: ");
        System.out.println("____________________________________");

        System.out.println("Tipo de identificación: ");
        String tipoIdentificacion = leerDatoTeclado.nextLine();

        System.out.println("Documento de identificación: ");
        String documentoIdentificacion = leerDatoTeclado.nextLine();

        System.out.println("Nombres: ");
        String nombres = leerDatoTeclado.nextLine();

        System.out.println("Apellidos: ");
        String apellidos = leerDatoTeclado.nextLine();

        System.out.println("Correo Electrónico: ");
        String correoElectronico = leerDatoTeclado.nextLine();

        System.out.println("Dirección de residencia: ");
        String direccionResidencia = leerDatoTeclado.nextLine();

        System.out.println("Ciudad de residencia: ");
        String ciudadResidencia = leerDatoTeclado.nextLine();

        System.out.println("Teléfono de contacto: ");
        String telefonoContacto = leerDatoTeclado.nextLine();

        String contraseña = solicitarContraseña();

        registrarUsuario(tipoIdentificacion,documentoIdentificacion, nombres, apellidos, correoElectronico, direccionResidencia, ciudadResidencia, telefonoContacto, contraseña);
    }

    // public static void mostrarClientesRegistrados(){
    //     System.out.println("____________________________________");
    //     System.out.println("Clientes registrados: ");
    //     for (String[] cliente : clientes){
    //         System.out.println("Tipo de identificación: " + cliente[TIPO_INDENTIFICACION]);
    //         System.out.println("Documento de identificación: " + cliente[DOUCUMENTO_INDENTIFICACION]);
    //         System.out.println("Nombres: " + cliente[NOMBRES]);
    //         System.out.println("Apellidos: " + cliente[APELLIDOS]);
    //         System.out.println("Correo Electrónico: " + cliente[CORREO_ELECTRONICO]);
    //         System.out.println("Dirección de residencia: " + cliente[DIRECCION_RESIDENCIA]);
    //         System.out.println("Ciudad de residencia: " + cliente[CIUDAD_RESIDENCIA]);
    //         System.out.println("Teléfono de contacto: " + cliente[TELEFONO_CONTACTO]);
    //         System.out.println("Contraseña: " + cliente[CONTRESEÑA]);
    //         System.out.println("____________________________________");
    //     }
    // }

    // Metodo que valida si los datos de inicio de sesion son correctos
    public static boolean inciarSesion(String correoElectronico, String contraseña){
        boolean validacionDeIngreso = false;
        for(String[] cliente : clientes){
            if(cliente[CORREO_ELECTRONICO].equalsIgnoreCase(correoElectronico) && cliente[CONTRESEÑA].equals(contraseña)){
                return validacionDeIngreso = true;
            }
        }
        return validacionDeIngreso;
    }

    // Metodo que solicita los datos de inicio de sesion al usuario y valida con el metodo inciarSesion
    public static boolean solicitarDatosInicioSesion(){
        System.out.println("____________________________________");
        System.out.println("Inicio de sesión.");
        System.out.println("Para iniciar sesión, por favor facilitar la siguiente infomación: ");
        System.out.println("____________________________________");

        boolean validacionDeIngreso = false;
        String correoElectronico = new String();
        String contraseña = new String();

        for(int intentosIngreso = 0; intentosIngreso < 3; intentosIngreso++){
            System.out.println("Correo Electrónico: ");
            correoElectronico = leerDatoTeclado.nextLine();

            System.out.println("Contraseña: ");
            contraseña = leerDatoTeclado.nextLine();

            validacionDeIngreso = inciarSesion(correoElectronico, contraseña);

            if(validacionDeIngreso){
                System.out.println("____________________________________");
                System.out.println("Usuario logeado correctamente.");
                System.out.println("-------Bienvenido---------");
                System.out.println("____________________________________");
                break;
            } else {
                if(intentosIngreso < 2){
                    System.out.println("Correo Electrónico o contraseña incorrectos. Por favor intentelo de nuevo.");
                }
            }
        }

        return validacionDeIngreso;
    }

    // Metodo que toma la opcion seleccionada por el usuario y llama a los metodos correspondientes
    public static void mostrarMenuLoginRegistro() {
        boolean mostrarMenu = true;
        int opcion;
        
        while(mostrarMenu){
            menu();
            System.out.print("Opción: ");
            opcion = leerDatoTeclado.nextInt();
            leerDatoTeclado.nextLine();
            switch (opcion) {
                case 1:
                    solicitarDatosDeRegistro();
                    break;
                case 2:
                    boolean validacionDeIngreso = solicitarDatosInicioSesion();
                    if(!validacionDeIngreso){
                        System.out.println("Ha superado el número de intentos permitidos.");
                        mostrarMenu = false;
                    }
                    break;
                case 3:
                    mostrarMenu = false;
                    break;
                default:
                    System.out.println("Ingrese una una opción valida");
                    break;
            }
        }
        leerDatoTeclado.close();  
    }


    public static void main(String[] args) {
        mostrarMenuLoginRegistro();
    } 
    
}