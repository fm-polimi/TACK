package formulae.cltloc.atoms;

import formulae.cltloc.visitor.CLTLocVisitor;

public class CLTLocAP extends CLTLocAtom {

	private final int hash;
	private final String atomName;

	public CLTLocAP(String atom) {
		super();
		this.atomName = atom;
		this.hash = atomName.hashCode();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T accept(CLTLocVisitor<T> t) {
		return t.visit(this);
	}

	@Override
	public int hashCode() {
		return this.hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CLTLocAP other = (CLTLocAP) obj;
		if (atomName == null) {
			if (other.atomName != null)
				return false;
		} else if (!atomName.equals(other.atomName))
			return false;
		if (hash != other.hash)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.atomName;
	}
}