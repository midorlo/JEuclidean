package com.midorlo.jeuclidean;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

@EqualsAndHashCode(callSuper = false)
@Data
public class EuclideanObjectUi extends JPanel {

    private final           EuclideanObject model;
    private transient final JLabel          idLabel;
    private transient final JLabel          positionLabel;

    public EuclideanObjectUi(EuclideanObject model) {

        super(new BorderLayout());
        setBorder(new EtchedBorder());
        this.model         = model;
        this.idLabel       = createIdLabel(this.model);
        this.positionLabel = createPositionLabel(this.model);
        add(idLabel,BorderLayout.NORTH);
        add(positionLabel,BorderLayout.CENTER);
    }

    private JLabel createIdLabel(EuclideanObject model) {

        JLabel l = new JLabel();
        l.setText(this.model.getId());
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setVerticalAlignment(SwingConstants.CENTER);
        return l;
    }

    private JLabel createPositionLabel(EuclideanObject model) {

        JLabel l    = new JLabel();
        String text = String.format(" %d | %d | %d", model.getX(), model.getY(), model.getZ());
        l.setText(text);
        l.setHorizontalAlignment(SwingConstants.CENTER);
        l.setVerticalAlignment(SwingConstants.CENTER);
        return l;
    }
}
