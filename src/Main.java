
/**
 * Sistema de Bitácora de la USS Algoritmo
 * Implementación del TDA Pila para registro de eventos de nave
 * 
 * @author [TU NOMBRE]
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * Clase que implementa el TDA Pila para la bitácora de la nave
 */
class BitacoraStack {
    private List<String> eventos;

    public BitacoraStack() {
        this.eventos = new ArrayList<>();
    }

    /**
     * Agrega un nuevo evento a la cima de la bitácora (push)
     */
    public void registrar(String evento) {
        eventos.add(evento);
    }

    /**
     * Devuelve el último evento sin eliminarlo (top/peek)
     * 
     * @throws EmptyStackException si la bitácora está vacía
     */
    public String consultarUltimo() {
        if (estaVacia()) {
            throw new EmptyStackException();
        }
        return eventos.get(eventos.size() - 1);
    }

    /**
     * Elimina y devuelve el último evento registrado (pop)
     * 
     * @throws EmptyStackException si la bitácora está vacía
     */
    public String eliminarUltimo() {
        if (estaVacia()) {
            throw new EmptyStackException();
        }
        return eventos.remove(eventos.size() - 1);
    }

    /**
     * Verifica si la bitácora está vacía
     */
    public boolean estaVacia() {
        return eventos.isEmpty();
    }

    /**
     * Retorna el número de eventos actuales
     */
    public int totalEventos() {
        return eventos.size();
    }

    /**
     * Muestra todos los eventos (método auxiliar)
     */
    public void mostrarBitacora() {
        System.out.println("\n=== CONTENIDO DE LA BITÁCORA ===");
        for (int i = 0; i < eventos.size(); i++) {
            System.out.println((i + 1) + ". " + eventos.get(i));
        }
        System.out.println("=================================");
    }
}

/**
 * Clase principal con la misión de la USS Algoritmo
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  USS ALGORITMO - SISTEMA DE BITÁCORA  ");
        System.out.println("========================================");
        System.out.println("Oficial de Sistemas: Iniciando registro...\n");

        // Crear la bitácora
        BitacoraStack bitacora = new BitacoraStack();

        // PASO 1: Registrar los 6 eventos
        System.out.println(">> Registrando eventos de la misión...");
        String[] eventosMision = {
                "Motor de estribor encendido",
                "Velocidad warp alcanzada",
                "Señal de comunicación estable",
                "Anomalía detectada en sector 7",
                "Escudos al 40%",
                "ERROR CRÍTICO: fallo en sistema de navegación"
        };

        for (String evento : eventosMision) {
            System.out.println("   + " + evento);
            bitacora.registrar(evento);
        }

        // PASO 2: Consultar último evento
        System.out.println("\n>> Consultando último evento registrado:");
        String ultimoEvento = bitacora.consultarUltimo();
        System.out.println("   ÚLTIMO EVENTO: \"" + ultimoEvento + "\"");

        // PASO 3: Protocolo de revisión
        System.out.println("\n>> Verificando protocolo de seguridad...");
        if (ultimoEvento.contains("ERROR")) {
            System.out.println("   ¡ALERTA! Se detectó un ERROR CRÍTICO.");
            System.out.println("   Activando protocolo de revisión: eliminando últimos 3 eventos...\n");

            for (int i = 1; i <= 3; i++) {
                String eventoEliminado = bitacora.eliminarUltimo();
                System.out.println("   Eliminado evento #" + i + ": \"" + eventoEliminado + "\"");
            }

            System.out.println("\n   ✓ Protocolo de revisión completado.");
        }

        // PASO 4: Estado actual
        System.out.println("\n>> ESTADO ACTUAL DE LA BITÁCORA:");
        System.out.println("   Total de eventos restantes: " + bitacora.totalEventos());

        if (!bitacora.estaVacia()) {
            System.out.println("   Evento en la cima actual: \"" + bitacora.consultarUltimo() + "\"");
        }

        // Mostrar bitácora completa
        bitacora.mostrarBitacora();

        // Demostración de excepciones
        System.out.println("\n>> Demostración de manejo de errores:");
        demostrarManejoExcepciones();

        // Parte 3: Pregunta de reflexión
        System.out.println("\n========================================");
        System.out.println("           PREGUNTA DE REFLEXIÓN        ");
        System.out.println("========================================");
        System.out.println("""
                ¿Por qué una Pila es la estructura correcta para este sistema de bitácora?

                RESPUESTA: La pila es la estructura ideal porque el registro de eventos sigue el
                principio LIFO (Last In, First Out) - el último evento es el más relevante para
                emergencias. Si usara una lista normal accediendo por índice, perdería la semántica
                natural de la bitácora y tendría que gestionar manualmente las posiciones. La pila
                garantiza que siempre trabajemos con el evento más reciente de forma eficiente.""");

        System.out.println("\n========================================");
        System.out.println("  BITÁCORA FINALIZADA - MISIÓN COMPLETA ");
        System.out.println("========================================");
    }

    private static void demostrarManejoExcepciones() {
        BitacoraStack pilaVacia = new BitacoraStack();

        try {
            System.out.println("   Intentando consultar último en pila vacía...");
            pilaVacia.consultarUltimo();
        } catch (EmptyStackException e) {
            System.out.println("   ✓ EXCEPCIÓN: No se puede consultar en pila vacía");
        }

        try {
            System.out.println("   Intentando eliminar último en pila vacía...");
            pilaVacia.eliminarUltimo();
        } catch (EmptyStackException e) {
            System.out.println("   ✓ EXCEPCIÓN: No se puede eliminar en pila vacía");
        }
    }
}