package util;

import javax.swing.*;
import java.awt.*;

public class Navegador {

    private static CardLayout cardLayout;

    private static JPanel painel;

    public static void configurar(
            CardLayout layout,
            JPanel painelCentral) {

        cardLayout = layout;
        painel = painelCentral;
    }

    public static void mostrar(
            String tela) {

        cardLayout.show(
                painel,
                tela);
    }
}