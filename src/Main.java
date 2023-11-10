import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //Creación de listas para que se guarden.
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        ArrayList<Customer> customerList = new ArrayList<>();
        ArrayList<SalesData> salesDataList = new ArrayList<>();

        //declaracion de variables
        Vehicle vehicle = new Vehicle();
        Customer customer = new Customer();
        boolean exit = false;

        //Creacion de un menú
        do {
            System.out.println("Menú:");
            System.out.println("1. Registrar vehiculo");
            System.out.println("2. Registrar cliente");
            System.out.println("3. Registrar venta");
            System.out.println("4. Salir");
            System.out.println("(Introduce solo el numero)");

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    //VEHICULO


                    //Introducir datos del vehiculo
                    System.out.println("Introduce los datos del vehículo:");
                    System.out.println("Matrícula:");
                    vehicle.setCarLicensePlate(sc.nextLine());
                    System.out.println("Marca:");
                    vehicle.setBrand(sc.nextLine());
                    System.out.println("Modelo:");
                    vehicle.setModel(sc.nextLine());
                    System.out.println("Color:");
                    vehicle.setColour(sc.nextLine());
                    System.out.println("Tipo de combustible:");
                    vehicle.setFuel(sc.nextLine());
                    System.out.println("Motor:");
                    vehicle.setEngine(sc.nextLine());
                    System.out.println("Caballos de potencia (en número):");
                    vehicle.setHorsePower(sc.nextInt());


                    //Agregar el vehiculo a la lista de vehiculos
                    vehicleList.add(vehicle);

                    System.out.println("Vehiculo registrado con éxito.");

                    break;

                case 2:
                    //CLIENTE

                    //permitir al usuario introducir clientes
                    customer = new Customer();
                    //Introducir datos del cliente
                    System.out.println("Introduce los datos del cliente:");
                    System.out.println("DNI:");
                    customer.setDni(sc.nextLine());
                    System.out.println("Nombre:");
                    customer.setName(sc.nextLine());
                    System.out.println("Apellidos:");
                    customer.setSurname(sc.nextLine());
                    System.out.println("Dirección:");
                    customer.setDirection(sc.nextLine());

                    //Agregar el cliente a la lista de clientes
                    customerList.add(customer);

                    System.out.println("Cliente registrado con exito.");

                    break;

                case 3:
                    //VENTA

                    //permitir al usuario introducir datos de venta
                    SalesData salesData = new SalesData();
                    //Introducir datos de la venta
                    System.out.println("Introduce los datos de la venta:");
                    System.out.println("Código de venta:");
                    salesData.setSalesCode(sc.nextInt());
                    System.out.println("Fecha de la venta:");
                    salesData.setSalesDate(sc.nextLine());
                    sc.nextLine();
                    System.out.println("Forma de pago:");
                    salesData.setMethodOfPayment(sc.nextLine());
                    System.out.println("Precio de la venta:");
                    salesData.setSalePrice(sc.nextDouble());

                    //Introducir los datos del vehículo que quiere para añadir en la venta
                    System.out.println("Matricula del vehiculo vendido:");
                    String carLicensePlate = sc.nextLine();
                    sc.nextLine();
                    Vehicle foundVehicle = null;

                    for (Vehicle soldVehicle : vehicleList) {
                        if (soldVehicle.getCarLicensePlate().equalsIgnoreCase(carLicensePlate)) {
                            foundVehicle = soldVehicle;
                            break;
                        }
                    }

                    if (foundVehicle != null) {
                        System.out.println("¡Vehiculo encontrado!");
                        salesData.setVehicle(foundVehicle);
                    } else {
                        //Si el vehiculo no existe, pide al usuario que lo cree
                        System.out.println("El vehiculo no existe. Regístrelo primero:");

                        vehicle = new Vehicle();

                        System.out.println("Matrícula:");
                        vehicle.setCarLicensePlate(sc.nextLine());
                        System.out.println("Marca:");
                        vehicle.setBrand(sc.nextLine());
                        System.out.println("Modelo:");
                        vehicle.setModel(sc.nextLine());
                        System.out.println("Color:");
                        vehicle.setColour(sc.nextLine());
                        System.out.println("Tipo de combustible:");
                        vehicle.setFuel(sc.nextLine());
                        System.out.println("Motor:");
                        vehicle.setEngine(sc.nextLine());
                        System.out.println("Caballos de potencia (en número):");
                        vehicle.setHorsePower(sc.nextInt());
                        //Añadir el vehiculo a la lista de vehiculos
                        vehicleList.add(vehicle);
                        //Asociar el vehiculo con la venta
                        salesData.setVehicle(vehicle);
                    }

                    //Introducir los datos del cliente que ha realizado la venta
                    System.out.println("Dni del cliente:");
                    String dni = sc.nextLine();
                    sc.nextLine();
                    Customer foundCustomer = null;

                    for (Customer buyerCustomer : customerList) {
                        if (buyerCustomer.getDni().equals(dni)) {
                            foundCustomer = buyerCustomer;
                            break;
                        }
                    }

                    if (foundCustomer != null) {
                        System.out.println("¡Cliente encontrado!");
                        salesData.setCustomer(foundCustomer);
                    } else {
                        //Si el cliente no existe, pide al usuario que lo cree
                        System.out.println("El cliente no existe. Regístrelo primero:");

                        customer = new Customer();

                        System.out.println("DNI:");
                        customer.setDni(sc.nextLine());
                        System.out.println("Nombre:");
                        customer.setName(sc.nextLine());
                        System.out.println("Apellidos:");
                        customer.setSurname(sc.nextLine());
                        System.out.println("Dirección:");
                        customer.setDirection(sc.nextLine());

                        //Añadir el cliente al listado de clientes
                        customerList.add(customer);
                        //Asociar el cliente con la venta
                        salesData.setCustomer(customer);
                    }

                    //Implementacion de la venta al listado de ventas
                    salesDataList.add(salesData);

                    //Impresión de la factura
                    System.out.println("FACTURA:");
                    System.out.println("Codigo de venta: " + salesData.getSalesCode());
                    System.out.println("Fecha de venta: " + salesData.getSalesDate());
                        //Datos del cliente
                    Customer customers = salesData.getCustomer(customer);
                    System.out.println("Cliente:");
                    System.out.println("Nombre: " + customer.getName());
                    System.out.println("Apellidos: " + customer.getSurname());
                    System.out.println("DNI: " + customer.getDni());
                    System.out.println("Direccion: " + customer.getDirection());
                        //Datos del vehiculo
                    System.out.println("Vehiculo:");
                    System.out.println("Matricula: " + vehicle.getCarLicensePlate());
                    System.out.println("Marca: " + vehicle.getBrand());
                    System.out.println("Modelo: " + vehicle.getModel());
                    System.out.println("Color: " + vehicle.getColour());
                    System.out.println("Tipo de combustible: " + vehicle.getFuel());
                    System.out.println("Motor: " + vehicle.getEngine());
                    System.out.println("Caballos: " + vehicle.getHorsePower() + "CV");

                    System.out.println("Forma de pago: " + salesData.getMethodOfPayment());
                    System.out.println("Precio de venta: " + salesData.getSalePrice() + "€");

                    break;

                case 4:
                    exit = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo...");
            }
        } while (!exit);
        sc.close();
    }
}
