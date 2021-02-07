package micro;

/*** BNFC-Generated Visitor Design Pattern Skeleton. ***/

/* This implements the common visitor design pattern.
   Tests show it to be slightly less efficient than the
   instanceof method, but easier to use.
   Replace the R and A parameters with the desired return
   and context types.*/

public class VisitSkel
{
  public class ProgVisitor<R,A> implements micro.Absyn.Prog.Visitor<R,A>
  {
    public R visit(micro.Absyn.Program p, A arg)
    { /* Code for Program goes here */
      for (micro.Absyn.Stm x: p.liststm_) {
        x.accept(new StmVisitor<R,A>(), arg);
      }
      return null;
    }
  }
  public class StmVisitor<R,A> implements micro.Absyn.Stm.Visitor<R,A>
  {
    public R visit(micro.Absyn.SAssign p, A arg)
    { /* Code for SAssign goes here */
      //p.ident_;
      p.exp_.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }
    public R visit(micro.Absyn.SRead p, A arg)
    { /* Code for SRead goes here */
      for (String x: p.listident_) {
        //x;
      }
      return null;
    }
    public R visit(micro.Absyn.SWrite p, A arg)
    { /* Code for SWrite goes here */
      for (micro.Absyn.Exp x: p.listexp_) {
        x.accept(new ExpVisitor<R,A>(), arg);
      }
      return null;
    }
  }
  public class ExpVisitor<R,A> implements micro.Absyn.Exp.Visitor<R,A>
  {
    public R visit(micro.Absyn.EAdd p, A arg)
    { /* Code for EAdd goes here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }
    public R visit(micro.Absyn.ESub p, A arg)
    { /* Code for ESub goes here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }
    public R visit(micro.Absyn.EMul p, A arg)
    { /* Code for EMul goes here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }
    public R visit(micro.Absyn.EDiv p, A arg)
    { /* Code for EDiv goes here */
      p.exp_1.accept(new ExpVisitor<R,A>(), arg);
      p.exp_2.accept(new ExpVisitor<R,A>(), arg);
      return null;
    }
    public R visit(micro.Absyn.EInt p, A arg)
    { /* Code for EInt goes here */
      //p.integer_;
      return null;
    }
    public R visit(micro.Absyn.EDbl p, A arg)
    { /* Code for EDbl goes here */
      //p.double_;
      return null;
    }
    public R visit(micro.Absyn.EIdn p, A arg)
    { /* Code for EIdn goes here */
      //p.ident_;
      return null;
    }
  }
}
