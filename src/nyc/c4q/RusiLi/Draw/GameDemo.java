package nyc.c4q.RusiLi.Draw;

import nyc.c4q.RusiLi.Blackjack.Cards;
import nyc.c4q.RusiLi.Blackjack.Deck;
import nyc.c4q.RusiLi.Utility.Print;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

// http://docs.oracle.com/javase/tutorial/2d/geometry/strokeandfill.html

@SuppressWarnings("serial")
public class GameDemo extends JPanel {
    private int pnum;
    public Cards[] inputCard;

    // Stroke
    // final static float dash1[] = {10.0f};
    final static BasicStroke two = new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 0.0f, null, 0.0f);

    public GameDemo(int pnum, Cards[] inputCard){
        this.pnum = pnum;
        this.inputCard = inputCard;
    }

    @Override
    public void paint(Graphics g) {
        String temp = "";
        Graphics2D gfx = (Graphics2D) g;
        gfx.setStroke(two);
        gfx.setFont(new Font("Helvetica", Font.BOLD, 14));

        for (int i = 1; i <= pnum; i++) {
            ArrayList<JPanel> panelList = new ArrayList<>();
            JPanel newPanel = new JPanel();
            newPanel.setSize(50, 90);
            newPanel.setAlignmentX(30);
            newPanel.setAlignmentY(30);
            newPanel.setBackground(Color.WHITE);
            newPanel.setVisible(true);
            panelList.add(newPanel);

            if (inputCard[i].getCardSuit() == Cards.Suit.Diamonds || inputCard[i].getCardSuit() == Cards.Suit.Hearts){
                gfx.setColor(Color.RED);
            } else {
                gfx.setColor(Color.BLACK);
            }

            gfx.draw(new RoundRectangle2D.Double((40 + 120*(i-1)), 40, 80, 120, 3, 3));

            // Value Line 1
            if (inputCard[i].getInputValue() != 10) {
                temp += (inputCard[i].getCardValue() + "           " + inputCard[i].getCardValue());  // Down
                gfx.drawString(temp, (48 + 122*(i-1)), 62);
            } else if (inputCard[i].getInputValue() == 10) {
                temp += (inputCard[i].getCardValue() + "        " + inputCard[i].getCardValue());  // Down
                gfx.drawString(temp, (48 + 120*(i-1)), 62);
            }
            temp = "";

            // Suit Line
                if (inputCard[i].getCardSuit() == Cards.Suit.Clubs) {
                    gfx.drawString("♣", (73 + 121*(i-1)), 105);
                } else if (inputCard[i].getCardSuit() == Cards.Suit.Diamonds) {
                    gfx.drawString("♦", (73 + 121*(i-1)), 100);
                } else if (inputCard[i].getCardSuit() == Cards.Suit.Hearts) {
                    gfx.drawString("❤", (73 + 121*(i-1)), 105);
                } else if (inputCard[i].getCardSuit() == Cards.Suit.Spades) {
                    gfx.drawString("♠", (73 + 121*(i-1)), 100);
                }
            temp = "";

            // Value Line 2
            if (inputCard[i].getInputValue() != 10) {
                temp += (inputCard[i].getCardValue() + "           " + inputCard[i].getCardValue());  // Down
                gfx.drawString(temp, (48 + 122*(i-1)), 145);
            } else if (inputCard[i].getInputValue() == 10) {
                temp += (inputCard[i].getCardValue() + "        " + inputCard[i].getCardValue());  // Down
                gfx.drawString(temp, (48 + 120*(i-1)), 145);
            }
            temp = "";
        }
    }

    public static void main(String[] args) {
        Random randomGenerator = new Random();

        JFrame frame = new JFrame("Project Blackjack");
        Deck deck1 = new Deck();
        Cards[] dealerCards = new Cards[4];

        dealerCards[1] = deck1.drawCard(10);
        dealerCards[2] = deck1.drawCard(30);

        frame.add(new GameDemo(2, dealerCards));
        frame.setSize(750, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
