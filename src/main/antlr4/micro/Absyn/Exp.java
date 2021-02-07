package micro.Absyn; // Java Package generated by the BNF Converter.

public abstract class Exp implements java.io.Serializable {
  public abstract <R,A> R accept(Exp.Visitor<R,A> v, A arg);
  public interface Visitor <R,A> {
    public R visit(micro.Absyn.EAdd p, A arg);
    public R visit(micro.Absyn.ESub p, A arg);
    public R visit(micro.Absyn.EMul p, A arg);
    public R visit(micro.Absyn.EDiv p, A arg);
    public R visit(micro.Absyn.EInt p, A arg);
    public R visit(micro.Absyn.EDbl p, A arg);
    public R visit(micro.Absyn.EIdn p, A arg);

  }

}
