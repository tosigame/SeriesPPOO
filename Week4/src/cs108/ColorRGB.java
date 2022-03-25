package cs108;

/**
 * Une couleur représentée par ses composantes rouges, vertes et bleues.
 */
public final class ColorRGB {
    private final float r, g, b;

    /**
     * La couleur « rouge » (pur).
     */
    public final static ColorRGB RED = new ColorRGB(1, 0, 0);

    /**
     * La couleur « vert » (pur).
     */
    public final static ColorRGB GREEN = new ColorRGB(0, 1, 0);

    /**
     * La couleur « bleu » (pur).
     */
    public final static ColorRGB BLUE = new ColorRGB(0, 0, 1);

    /**
     * La couleur « noir ».
     */
    public final static ColorRGB BLACK = new ColorRGB(0, 0, 0);

    /**
     * La couleur « blanc ».
     */
    public final static ColorRGB WHITE = new ColorRGB(1, 1, 1);

    /**
     * Construit une couleur avec les composantes rouges, vertes et bleues
     * données, qui doivent être dans l'intervalle [0;1].
     *
     * @param r
     *            la composante rouge.
     * @param g
     *            la composante verte.
     * @param b
     *            la composante bleue.
     * @throws IllegalArgumentException
     *             si l'une des composantes est hors de l'intervalle [0;1].
     */
    public ColorRGB(double r, double g, double b) {
        if (! (0.0 <= r && r <= 1.0))
            throw new IllegalArgumentException("invalid red component: " + r);
        if (! (0.0 <= g && g <= 1.0))
            throw new IllegalArgumentException("invalid green component: " + g);
        if (! (0.0 <= b && b <= 1.0))
            throw new IllegalArgumentException("invalid blue component: " + b);

        this.r = (float) r;
        this.g = (float) g;
        this.b = (float) b;
    }

    /**
     * Construit une couleur en « déballant » les trois composantes RGB stockées
     * chacune sur 8 bits. La composante R est supposée occuper les bits 23 à
     * 16, la composante G les bits 15 à 8 et la composante B les bits 7 à 0.
     * Les composantes sont de plus supposées gamma-encodées selon le standard
     * sRGB.
     *
     * @param packedRGB
     *            la couleur encodée, au format RGB.
     */
    public ColorRGB(int packedRGB) {
        this(gammaDecode(((packedRGB >> 16) & 0xFF) / 255f),
                gammaDecode(((packedRGB >>  8) & 0xFF) / 255f),
                gammaDecode(((packedRGB >>  0) & 0xFF) / 255f));
    }

    /**
     * Retourne la composante rouge de la couleur, comprise entre 0 et 1.
     *
     * @return la composante rouge de la couleur.
     */
    public float r() { return r; }

    /**
     * Retourne la composante verte de la couleur, comprise entre 0 et 1.
     *
     * @return la composante verte de la couleur.
     */
    public float g() { return g; }

    /**
     * Retourne la composante bleue de la couleur, comprise entre 0 et 1.
     *
     * @return la composante bleue de la couleur.
     */
    public float b() { return b; }

    /**
     * Mélange la couleur réceptrice avec la proportion donnée de la couleur
     * passée en argument. Si la proportion vaut 0, la couleur retournée est la
     * même que la couleur réceptrice, alors que si elle vaut 1, la couleur est
     * la même que la couleur passée en argument.
     *
     * @param that
     *            la couleur avec laquelle mélanger la couleur réceptrice.
     * @param p
     *            la proportion de la couleur passée à inclure dans le mélange,
     *            comprise entre 0 et 1.
     * @return la couleur résultant du mélange.
     * @throws IllegalArgumentException
     *             si la proportion est hors de l'intervalle [0;1].
     */
    public ColorRGB mixWith(ColorRGB that, double p) {
        if (! (0.0 <= p && p <= 1.0))
            throw new IllegalArgumentException("invalid mix proportion: " + p);
        return new ColorRGB(r + p * (that.r - r), g + p * (that.g - g), b + p * (that.b - b));
    }

    /**
     * Convertit la couleur en une couleur AWT.
     * @return La couleur AWT correspondant à la couleur réceptrice.
     */
    public java.awt.Color toAWTColor() {
        return new java.awt.Color(gammaEncode(r), gammaEncode(g), gammaEncode(b));
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("(%f, %f, %f)", r, g, b);
    }

    // Gamma-encodage sRGB (voir p.ex. https://en.wikipedia.org/wiki/Srgb)
    private static float gammaEncode(float x) {
        if (x <= 0.0031308f)
            return 12.92f * x;
        else
            return (1f + 0.055f) * (float)Math.pow(x, 1f / 2.4) - 0.055f;
    }

    // Gamma-decodage sRGB (voir p.ex. https://en.wikipedia.org/wiki/Srgb)
    private static float gammaDecode(float x) {
        if (x <= 0.04045)
            return x / 12.92f;
        else
            return (float) Math.pow((x + 0.055f) / (1f + 0.055f), 2.4);
    }
}
