package fr.arpinum.cocoritest.affirmation;

import java.util.Collection;

import fr.arpinum.cocoritest.affirmation.booleene.AffirmationBooleene;
import fr.arpinum.cocoritest.affirmation.booleene.AffirmationBooleeneAuFeminin;
import fr.arpinum.cocoritest.affirmation.booleene.AffirmationBooleeneDeBase;
import fr.arpinum.cocoritest.affirmation.collection.AffirmationCollection;
import fr.arpinum.cocoritest.affirmation.collection.AffirmationCollectionDeBase;
import fr.arpinum.cocoritest.affirmation.objet.AffirmationObjet;
import fr.arpinum.cocoritest.affirmation.objet.AffirmationObjetAuFeminin;
import fr.arpinum.cocoritest.affirmation.objet.AffirmationObjetDeBase;

/**
 * Fabrique qui permet de construire les différentes affirmations.
 * Ne pas utiliser cette classe directement mais via <code>{@link Affirmations}</code>.
 */
public class FabriqueAffirmation {

	FabriqueAffirmation() {
	}

	/**
	 * Crée une nouvelle instance de <code>{@link AffirmationBooleene}</code>.
	 *
	 * @param booléen la cible de l'affirmation.
	 * @return l'affirmation créée.
	 */
	public AffirmationBooleene le(boolean booléen) {
		return new AffirmationBooleeneDeBase(booléen);
	}

	/**
	 * Crée une nouvelle instance de <code>{@link AffirmationBooleene}</code>.
	 *
	 * @param booléen la cible de l'affirmation.
	 * @return l'affirmation créée.
	 */
	public AffirmationBooleene cet(boolean booléen) {
		return le(booléen);
	}

	/**
	 * Crée une nouvelle instance de <code>{@link fr.arpinum.cocoritest.affirmation.booleene.AffirmationBooleeneAuFeminin}</code>.
	 *
	 * @param booléen la cible de l'affirmation.
	 * @return l'affirmation créée.
	 */
	public AffirmationBooleeneAuFeminin la(boolean booléen) {
		return new AffirmationBooleeneDeBase(booléen);
	}

	/**
	 * Crée une nouvelle instance de <code>{@link AffirmationBooleeneAuFeminin}</code>.
	 *
	 * @param booléen la cible de l'affirmation.
	 * @return l'affirmation créée.
	 */
	public AffirmationBooleeneAuFeminin cette(boolean booléen) {
		return la(booléen);
	}

	/**
	 * Crée une nouvelle instance de <code>{@link fr.arpinum.cocoritest.affirmation.objet.AffirmationObjet}</code>.
	 *
	 * @param objet la cible de l'affirmation.
	 * @return l'affirmation créée.
	 */
	public <T> AffirmationObjet<T> le(T objet) {
		return new AffirmationObjetDeBase<T>(objet);
	}

	/**
	 * Crée une nouvelle instance de <code>{@link AffirmationObjet}</code>.
	 *
	 * @param objet la cible de l'affirmation.
	 * @return l'affirmation créée.
	 */
	public <T> AffirmationObjet<T> cet(T objet) {
		return le(objet);
	}

	/**
	 * Crée une nouvelle instance de <code>{@link fr.arpinum.cocoritest.affirmation.objet.AffirmationObjetAuFeminin}</code>.
	 *
	 * @param objet la cible de l'affirmation.
	 * @return l'affirmation créée.
	 */
	public <T> AffirmationObjetAuFeminin<T> la(T objet) {
		return new AffirmationObjetDeBase<T>(objet);
	}

	/**
	 * Crée une nouvelle instance de <code>{@link AffirmationObjetAuFeminin}</code>.
	 *
	 * @param objet la cible de l'affirmation.
	 * @return l'affirmation créée.
	 */
	public <T> AffirmationObjetAuFeminin<T> cette(T objet) {
		return la(objet);
	}

	/**
	 * Crée une nouvelle instance de <code>{@link fr.arpinum.cocoritest.affirmation.collection.AffirmationCollection}</code>.
	 *
	 * @param éléments les cibles de l'affirmation.
	 * @return l'affirmation créée.
	 */
	public <T> AffirmationCollection<T> les(Collection<T> éléments) {
		return AffirmationCollectionDeBase.cree(éléments);
	}
}