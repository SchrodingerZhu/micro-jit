package micro.Absyn; // Java Package generated by the BNF Converter.

public class SWrite  extends Stm {
  public final ListExp listexp_;
  public SWrite(ListExp p1) { listexp_ = p1; }

  public <R,A> R accept(micro.Absyn.Stm.Visitor<R,A> v, A arg) { return v.visit(this, arg); }

  public boolean equals(java.lang.Object o) {
    if (this == o) return true;
    if (o instanceof micro.Absyn.SWrite) {
      micro.Absyn.SWrite x = (micro.Absyn.SWrite)o;
      return this.listexp_.equals(x.listexp_);
    }
    return false;
  }

  public int hashCode() {
    return this.listexp_.hashCode();
  }


}
