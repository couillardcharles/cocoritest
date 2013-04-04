package fr.arpinum.cocoritest.affirmation.objet;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import fr.arpinum.cocoritest.affirmation.ExceptionAffirmation;

public class TestAffirmationObjetDeBase {

	@Rule
	public ExpectedException politiqueException = ExpectedException.none();

	@Test
	public void onPeutAffirmerQuUnNombreEstLeMêmeNombre() {
		creeAffirmation(1).est(1);
	}

	@Test
	public void onNePeutPasAffirmerQuUnNombreEstUnNombreDifférent() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("La valeur est 1 et non 2.");

		creeAffirmation(1).est(2);
	}

	@Test
	public void onPeutAffirmerQuUnNombreNEstPasUnNombreDifférent() {
		creeAffirmation(1).nEstPas(2);
	}

	@Test
	public void onNePeutPasAffirmerQuUnNombreNEstPasLeMêmeNombre() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("La valeur est 1 alors que ce n'était pas voulu.");

		creeAffirmation(1).nEstPas(1);
	}

	@Test
	public void onNePeutPasAffirmerQuUneChaîneEstUneChaîneDifférente() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("La valeur est toto et non tutu.");

		creeAffirmation("toto").est("tutu");
	}

	@Test
	public void onPeutAffirmerQuUnObjetEstNul() {
		creeAffirmation(null).estNul();
		creeAffirmation(null).estNulle();
	}

	@Test
	public void onPeutAffirmerQuUnObjetNEstPasNul() {
		creeAffirmation("toto").nEstPasNul();
		creeAffirmation("toto").nEstPasNulle();
	}

	@Test
	public void onNePeutPasAffirmerQuUnObjetNonNulEstNul() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("La valeur est toto et non null.");

		creeAffirmation("toto").estNul();
	}

	@Test
	public void onNePeutPasAffirmerAuFémininQuUnObjetNonNulEstNul() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("La valeur est toto et non null.");

		creeAffirmation("toto").estNulle();
	}

	@Test
	public void onNePeutPasAffirmerQuUnObjetNulNEstPasNul() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("La valeur est null alors que ce n'était pas voulu.");

		creeAffirmation(null).nEstPasNul();
	}

	@Test
	public void onNePeutPasAffirmerAuFémininQuUnObjetNulNEstPasNul() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("La valeur est null alors que ce n'était pas voulu.");

		creeAffirmation(null).nEstPasNulle();
	}

	@Test
	public void onPeutAffirmerQuUnObjetRespecteUneSpecification() {
		creeAffirmation(1).respecte(créeSpecificationToujoursSatisfaite());
	}

	private Specification<Integer> créeSpecificationToujoursSatisfaite() {
		return new Specification<Integer>() {
			@Override
			public boolean estSatisfaitPar(Integer objet) {
				return true;
			}
		};
	}

	@Test
	public void onNePeutPasAffirmerATortQuUnObjetRespecteUneSpecification() {
		politiqueException.expect(ExceptionAffirmation.class);
		politiqueException.expectMessage("La valeur ne respecte pas la spécification");

		creeAffirmation(1).respecte(créeSpécificationJamaisSatisfaite());
	}

	private Specification<Integer> créeSpécificationJamaisSatisfaite() {
		return new Specification<Integer>() {
			@Override
			public boolean estSatisfaitPar(Integer objet) {
				return false;
			}
		};
	}

	private static <T> AffirmationObjetDeBase<T> creeAffirmation(T valeur) {
		return new AffirmationObjetDeBase<T>(valeur);
	}
}
