/**
 * 
 */
package util.game.oblivion;

import simple.util.do_str;

/**
 * <br>Created: Feb 25, 2009
 * @author Kenneth Pierce
 */
public class Ingredient {
	protected final String Name, Display;
	protected final int Effect1,
		Effect2,
		Effect3,
		Effect4;
	public Ingredient(String name, int effect1, int effect2, int effect3, int effect4) {
		Name = name;
		Effect1 = effect1;
		Effect2 = effect2;
		Effect3 = effect3;
		Effect4 = effect4;
		Display = do_str.padRight(30, ' ', name) + "[" + do_str.padRight(25, ' ', AlchemyConstants.getEffectString(effect1)) + "][" + do_str.padRight(25, ' ', AlchemyConstants.getEffectString(effect2)) + "][" + do_str.padRight(25, ' ', AlchemyConstants.getEffectString(effect3)) + "][" + do_str.padRight(25, ' ', AlchemyConstants.getEffectString(effect4) + "]");
	}
	/**
	 * @return the name
	 */
	protected final String getName() {
		return Name;
	}
	/**
	 * @return the effect1
	 */
	protected final int getEffect1() {
		return Effect1;
	}
	/**
	 * @return the effect2
	 */
	protected final int getEffect2() {
		return Effect2;
	}
	/**
	 * @return the effect3
	 */
	protected final int getEffect3() {
		return Effect3;
	}
	/**
	 * @return the effect4
	 */
	protected final int getEffect4() {
		return Effect4;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return Display;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof String) {
			return Name.equalsIgnoreCase((String)obj);
		} else if (obj instanceof Ingredient) {
			Ingredient tmp = (Ingredient)obj;
			return (tmp.Name.equalsIgnoreCase(Name)
					&& tmp.Effect1 == Effect1
					&& tmp.Effect2 == Effect2
					&& tmp.Effect3 == Effect3
					&& tmp.Effect4 == Effect4);
		}
		return super.equals(obj);
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Name.hashCode();
	}
}
