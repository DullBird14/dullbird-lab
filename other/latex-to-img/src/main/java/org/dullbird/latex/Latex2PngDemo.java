package org.dullbird.latex;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月20日 08:56:00
 */
public class Latex2PngDemo {
    public static void main(String[] args) {
//        String latexString = "x = a_0 + \\frac{1}{a_1 + \\frac{1}{a_2 + \\frac{1}{a_3 + a_4}}}";
        String latexString = "adfsdvcxv$%^&^*^&*@#$@123123|||||$%#$%12";
        String s = Latex2PngDemo.latex2Png(latexString);
        System.out.println(s);
    }

    public static String latex2Png(String latex) {
        try {
            TeXFormula formula = new TeXFormula(latex);
            // render the formla to an icon of the same size as the formula.
            TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY, 30);
            // insert a border
            icon.setInsets(new Insets(10, 10, 10, 10));
            // now create an actual image of the rendered equation
            BufferedImage image = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(), BufferedImage.TYPE_BYTE_GRAY);
            Graphics2D g2 = image.createGraphics();
            g2.setColor(Color.white);
            g2.fillRect(0, 0, icon.getIconWidth(), icon.getIconHeight());
            JLabel jl = new JLabel();
            jl.setForeground(new Color(0, 0, 0));
            icon.paintIcon(jl, g2, 0, 0);
            // at this point the image is created, you could also save it with ImageIO
            // saveImage(image, "png", "F:\\b.png");
            // ImageIO.write(image, "png", new File("F:\\c.png"));
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            try {
                ImageIO.write(image, "png", outputStream);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return null;
            }
            byte[] buffer = outputStream.toByteArray();
            BASE64Encoder encoder = new BASE64Encoder();
            return ("data:image/png;base64," + encoder.encode(buffer));
        } catch (Exception e) {
            // e.printStackTrace();
            // ExceptionUtil.log(log, e);
            System.err.println("公式解析有误：\n" + latex);
            // e.printStackTrace();
            return null;
        }
    }
}
