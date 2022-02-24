package cs108;

/**
 * Une file d'entiers de taille bornée.
 *
 * @author Michel Schinz
 */
public interface BoundedIntQueue {
    /**
     * Retourne la capacité de la file, c-à-d le nombre maximum d'éléments
     * qu'elle peut contenir.
     *
     * @return la capacité de la file.
     */
    public abstract int capacity();

    /**
     * Retourne la taille de la file, c-à-d le nombre d'éléments qu'elle
     * contient.
     *
     * @return la taille de la file.
     */
    public abstract int size();

    /**
     * Retourne vrai ssi la file est vide, c-à-d que sa taille est nulle.
     *
     * @return vrai ssi la file est vide.
     */
    public abstract boolean isEmpty();

    /**
     * Retourne vrai ssi la file est pleine, c-à-d que sa taille est égale à sa
     * capacité.
     *
     * @return vrai ssi la file est pleine.
     */
    public abstract boolean isFull();

    /**
     * Ajoute l'élément donné en fin de file.
     *
     * @param newElement
     *            l'élément à ajouter.
     * @throws java.lang.IllegalStateException
     *             si la file est pleine.
     */
    public abstract void addLast(int newElement);

    /**
     * Supprime et retourne l'élément en début de la file.
     *
     * @return l'élément en début de file.
     * @throws java.lang.IllegalStateException
     *             si la file est vide.
     */
    public abstract int removeFirst();
}
