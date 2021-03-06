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

package fr.arpinum.cocoritest.specification;

/**
 * Représente une spécification d'un objet.
 *
 * @param <T> le type d'objet concerné.
 */
public interface Specification<T> {

	/**
	 * Informe si la spécification n'est pas satisfaite par l'objet.
	 *
	 * @param objet l'objet sur lequel est vérifiée l'insatisfaction de la spécification.
	 * @return true si la spécification n'est pas satisfaite par l'objet, faux sinon.
	 */
	boolean estInsatisfaitePar(T objet);

	/**
	 * Le message décrivant pourquoi la spécification n'est pas satisfaite par l'objet.
	 *
	 * @param objet l'objet qui ne satisfait pas la spécification.
	 * @return le message décrivant pourquoi la spécification n'est pas satisfaite.
	 */
	String messageInsatisfactionPour(T objet);
}
