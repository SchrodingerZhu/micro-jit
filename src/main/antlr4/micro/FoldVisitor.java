package micro;

/** BNFC-Generated Fold Visitor */
public abstract class FoldVisitor<R,A> implements AllVisitor<R,A> {
    public abstract R leaf(A arg);
    public abstract R combine(R x, R y, A arg);

/* Prog */
    public R visit(micro.Absyn.Program p, A arg) {
      R r = leaf(arg);
      for (micro.Absyn.Stm x : p.liststm_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* Stm */
    public R visit(micro.Absyn.SAssign p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_.accept(this, arg), r, arg);
      return r;
    }
    public R visit(micro.Absyn.SRead p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(micro.Absyn.SWrite p, A arg) {
      R r = leaf(arg);
      for (micro.Absyn.Exp x : p.listexp_)
      {
        r = combine(x.accept(this, arg), r, arg);
      }
      return r;
    }

/* Exp */
    public R visit(micro.Absyn.EAdd p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_1.accept(this, arg), r, arg);
      r = combine(p.exp_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(micro.Absyn.ESub p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_1.accept(this, arg), r, arg);
      r = combine(p.exp_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(micro.Absyn.EMul p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_1.accept(this, arg), r, arg);
      r = combine(p.exp_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(micro.Absyn.EDiv p, A arg) {
      R r = leaf(arg);
      r = combine(p.exp_1.accept(this, arg), r, arg);
      r = combine(p.exp_2.accept(this, arg), r, arg);
      return r;
    }
    public R visit(micro.Absyn.EInt p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(micro.Absyn.EDbl p, A arg) {
      R r = leaf(arg);
      return r;
    }
    public R visit(micro.Absyn.EIdn p, A arg) {
      R r = leaf(arg);
      return r;
    }


}
