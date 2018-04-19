package util;

import java.awt.GridBagConstraints;

class GBC extends GridBagConstraints
{
    private static final long serialVersionUID = 1L;

    public GBC(int gridx, int gridy)
    {
        this.gridx = gridx;
        this.gridy = gridy;
    }

    public GBC(int gridx, int gridy, int gridwidth, int gridheight)
    {
        this.gridx = gridx;
        this.gridy = gridy;
        this.gridwidth = gridwidth;
        this.gridheight = gridheight;
    }

    public GBC setAnchor(int anchor)
    {
        this.anchor = anchor;
        return this;
    }

    public GBC setFill(int fill)
    {
        this.fill = fill;
        return this;
    }

    public GBC setWeight(double weightx, double weighty)
    {
        this.weightx = weightx;
        this.weighty = weighty;
        return this;
    }
}