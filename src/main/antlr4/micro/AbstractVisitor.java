package micro;

/** BNFC-Generated Abstract Visitor */

public class AbstractVisitor<R,A> implements AllVisitor<R,A> {
    /* Prog */
    public R visit(micro.Absyn.Program p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(micro.Absyn.Prog p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* Stm */
    public R visit(micro.Absyn.SAssign p, A arg) { return visitDefault(p, arg); }
    public R visit(micro.Absyn.SRead p, A arg) { return visitDefault(p, arg); }
    public R visit(micro.Absyn.SWrite p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(micro.Absyn.Stm p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }
    /* Exp */
    public R visit(micro.Absyn.EAdd p, A arg) { return visitDefault(p, arg); }
    public R visit(micro.Absyn.ESub p, A arg) { return visitDefault(p, arg); }
    public R visit(micro.Absyn.EMul p, A arg) { return visitDefault(p, arg); }
    public R visit(micro.Absyn.EDiv p, A arg) { return visitDefault(p, arg); }
    public R visit(micro.Absyn.EInt p, A arg) { return visitDefault(p, arg); }
    public R visit(micro.Absyn.EDbl p, A arg) { return visitDefault(p, arg); }
    public R visit(micro.Absyn.EIdn p, A arg) { return visitDefault(p, arg); }
    public R visitDefault(micro.Absyn.Exp p, A arg) {
      throw new IllegalArgumentException(this.getClass().getName() + ": " + p);
    }

}
