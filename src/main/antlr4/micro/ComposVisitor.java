package micro;
/** BNFC-Generated Composition Visitor
*/

public class ComposVisitor<A> implements
  micro.Absyn.Prog.Visitor<micro.Absyn.Prog,A>,
  micro.Absyn.Stm.Visitor<micro.Absyn.Stm,A>,
  micro.Absyn.Exp.Visitor<micro.Absyn.Exp,A>
{
    /* Prog */
    public micro.Absyn.Prog visit(micro.Absyn.Program p, A arg)
    {
      micro.Absyn.ListStm liststm_ = new micro.Absyn.ListStm();
      for (micro.Absyn.Stm x : p.liststm_)
      {
        liststm_.add(x.accept(this,arg));
      }
      return new micro.Absyn.Program(liststm_);
    }

    /* Stm */
    public micro.Absyn.Stm visit(micro.Absyn.SAssign p, A arg)
    {
      String ident_ = p.ident_;
      micro.Absyn.Exp exp_ = p.exp_.accept(this, arg);
      return new micro.Absyn.SAssign(ident_, exp_);
    }
    public micro.Absyn.Stm visit(micro.Absyn.SRead p, A arg)
    {
      micro.Absyn.ListIdent listident_ = p.listident_;
      return new micro.Absyn.SRead(listident_);
    }
    public micro.Absyn.Stm visit(micro.Absyn.SWrite p, A arg)
    {
      micro.Absyn.ListExp listexp_ = new micro.Absyn.ListExp();
      for (micro.Absyn.Exp x : p.listexp_)
      {
        listexp_.add(x.accept(this,arg));
      }
      return new micro.Absyn.SWrite(listexp_);
    }

    /* Exp */
    public micro.Absyn.Exp visit(micro.Absyn.EAdd p, A arg)
    {
      micro.Absyn.Exp exp_1 = p.exp_1.accept(this, arg);
      micro.Absyn.Exp exp_2 = p.exp_2.accept(this, arg);
      return new micro.Absyn.EAdd(exp_1, exp_2);
    }
    public micro.Absyn.Exp visit(micro.Absyn.ESub p, A arg)
    {
      micro.Absyn.Exp exp_1 = p.exp_1.accept(this, arg);
      micro.Absyn.Exp exp_2 = p.exp_2.accept(this, arg);
      return new micro.Absyn.ESub(exp_1, exp_2);
    }
    public micro.Absyn.Exp visit(micro.Absyn.EMul p, A arg)
    {
      micro.Absyn.Exp exp_1 = p.exp_1.accept(this, arg);
      micro.Absyn.Exp exp_2 = p.exp_2.accept(this, arg);
      return new micro.Absyn.EMul(exp_1, exp_2);
    }
    public micro.Absyn.Exp visit(micro.Absyn.EDiv p, A arg)
    {
      micro.Absyn.Exp exp_1 = p.exp_1.accept(this, arg);
      micro.Absyn.Exp exp_2 = p.exp_2.accept(this, arg);
      return new micro.Absyn.EDiv(exp_1, exp_2);
    }
    public micro.Absyn.Exp visit(micro.Absyn.EInt p, A arg)
    {
      Integer integer_ = p.integer_;
      return new micro.Absyn.EInt(integer_);
    }
    public micro.Absyn.Exp visit(micro.Absyn.EDbl p, A arg)
    {
      Double double_ = p.double_;
      return new micro.Absyn.EDbl(double_);
    }
    public micro.Absyn.Exp visit(micro.Absyn.EIdn p, A arg)
    {
      String ident_ = p.ident_;
      return new micro.Absyn.EIdn(ident_);
    }
}
