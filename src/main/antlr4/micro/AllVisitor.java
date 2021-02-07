package micro;

/** BNFC-Generated All Visitor */

public interface AllVisitor<R,A> extends
  micro.Absyn.Prog.Visitor<R,A>,
  micro.Absyn.Stm.Visitor<R,A>,
  micro.Absyn.Exp.Visitor<R,A>
{}
