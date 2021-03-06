/*
 * Copyright (C) 2013, Arpinum
 *
 * Cocoritest est un logiciel libre ; vous pouvez le redistribuer ou le modifier suivant les termes de la GNU Lesser
 * General Public License telle que publiée par la Free Software Foundation ; soit la version 3 de la licence,
 * soit (à votre gré) toute version ultérieure.
 *
 * Cocoritest est distribué dans l'espoir qu'il sera utile, mais SANS AUCUNE GARANTIE ; pas même la garantie
 * implicite de COMMERCIABILISABILITÉ ni d'ADÉQUATION à UN OBJECTIF PARTICULIER. Consultez la GNU Lesser General
 * Public License pour plus de détails.
 *
 * Vous devez avoir reçu une copie de la GNU Lesser General Public License en même temps que Cocoritest ; si ce n'est
  * pas le cas, consultez http://www.gnu.org/licenses.
 */

package fr.arpinum.cocoritest;

import fr.arpinum.cocoritest.affirmation.ExceptionAffirmation;
import fr.arpinum.cocoritest.outils.Objets;
import fr.arpinum.cocoritest.specification.FabriqueSpecification;
import fr.arpinum.cocoritest.specification.Specification;
import fr.arpinum.cocoritest.specification.objet.SpecificationAutreObjet;

public abstract class Fabrique {

	public static Specification<Exception> spécificationException(String messageAttendu) {
		SpecificationAutreObjet<Exception> nonNulle = new SpecificationAutreObjet<Exception>(null);
		Specification<Exception> deTypeAffirmation = créeSpécificationObjetDeType(ExceptionAffirmation.class);
		Specification<Exception> avecMessage = créeSpécificationMessageException(messageAttendu);
		return new FabriqueSpecification().combine(nonNulle, deTypeAffirmation, avecMessage);
	}

	private static Specification<Exception> créeSpécificationMessageException(final String messageAttendu) {
		return new Specification<Exception>() {
			@Override
			public boolean estInsatisfaitePar(Exception objet) {
				return Objets.différents(objet.getMessage(), messageAttendu);
			}

			@Override
			public String messageInsatisfactionPour(Exception objet) {
				return String.format("Le message est <%s> au lieu de <%s>", objet.getMessage(), messageAttendu);
			}
		};
	}

	private static Specification<Exception> créeSpécificationObjetDeType(final Class<?> classe) {
		return new Specification<Exception>() {
			@Override
			public boolean estInsatisfaitePar(Exception objet) {
				return !objet.getClass().equals(classe);
			}

			@Override
			public String messageInsatisfactionPour(Exception objet) {
				return String.format("Le type est <%s> au lieu de <%s>", objet.getClass(), classe);
			}
		};
	}

	public static <T> Specification<T> spécificationSatisfaite() {
		return new Specification<T>() {
			@Override
			public boolean estInsatisfaitePar(T objet) {
				return false;
			}

			@Override
			public String messageInsatisfactionPour(T objet) {
				return "non utilisé";
			}
		};
	}

	public static <T> Specification<T> spécificationInsatisfaite() {
		return new Specification<T>() {
			@Override
			public boolean estInsatisfaitePar(T objet) {
				return true;
			}

			@Override
			public String messageInsatisfactionPour(T objet) {
				return objet + " ne respecte pas la spécification.";
			}
		};
	}
}
