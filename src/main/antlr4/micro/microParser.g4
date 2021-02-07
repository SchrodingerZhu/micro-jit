// -*- Java -*- This ANTLRv4 file was machine-generated by BNFC
parser grammar microParser;

options {
  tokenVocab = microLexer;
}

@members {
}

start_Prog returns [ micro.Absyn.Prog result ]
  : x=prog EOF
    { $result = $x.result; }
  ;
start_Stm returns [ micro.Absyn.Stm result ]
  : x=stm EOF
    { $result = $x.result; }
  ;
start_Exp returns [ micro.Absyn.Exp result ]
  : x=exp EOF
    { $result = $x.result; }
  ;
start_Exp1 returns [ micro.Absyn.Exp result ]
  : x=exp1 EOF
    { $result = $x.result; }
  ;
start_Exp2 returns [ micro.Absyn.Exp result ]
  : x=exp2 EOF
    { $result = $x.result; }
  ;
start_ListIdent returns [ micro.Absyn.ListIdent result ]
  : x=listIdent EOF
    { $result = $x.result; }
  ;
start_ListExp returns [ micro.Absyn.ListExp result ]
  : x=listExp EOF
    { $result = $x.result; }
  ;
start_ListStm returns [ micro.Absyn.ListStm result ]
  : x=listStm EOF
    { $result = $x.result; }
  ;

prog returns [ micro.Absyn.Prog result ]
  : Surrogate_id_SYMB_9 p_1_2=listStm Surrogate_id_SYMB_10
    { $result = new micro.Absyn.Program($p_1_2.result); }
  ;
stm returns [ micro.Absyn.Stm result ]
  : p_1_1=IDENT Surrogate_id_SYMB_0 p_1_3=exp
    { $result = new micro.Absyn.SAssign($p_1_1.getText(),$p_1_3.result); }
  | Surrogate_id_SYMB_11 Surrogate_id_SYMB_1 p_2_3=listIdent Surrogate_id_SYMB_2
    { $result = new micro.Absyn.SRead($p_2_3.result); }
  | Surrogate_id_SYMB_12 Surrogate_id_SYMB_1 p_3_3=listExp Surrogate_id_SYMB_2
    { $result = new micro.Absyn.SWrite($p_3_3.result); }
  ;
exp returns [ micro.Absyn.Exp result ]
  : p_1_1=exp Surrogate_id_SYMB_3 p_1_3=exp1
    { $result = new micro.Absyn.EAdd($p_1_1.result,$p_1_3.result); }
  | p_2_1=exp Surrogate_id_SYMB_4 p_2_3=exp1
    { $result = new micro.Absyn.ESub($p_2_1.result,$p_2_3.result); }
  | p_3_1=exp1
    { $result = $p_3_1.result; }
  ;
exp1 returns [ micro.Absyn.Exp result ]
  : p_1_1=exp1 Surrogate_id_SYMB_5 p_1_3=exp2
    { $result = new micro.Absyn.EMul($p_1_1.result,$p_1_3.result); }
  | p_2_1=exp1 Surrogate_id_SYMB_6 p_2_3=exp2
    { $result = new micro.Absyn.EDiv($p_2_1.result,$p_2_3.result); }
  | p_3_1=exp2
    { $result = $p_3_1.result; }
  ;
exp2 returns [ micro.Absyn.Exp result ]
  : p_1_1=INTEGER
    { $result = new micro.Absyn.EInt(Integer.parseInt($p_1_1.getText())); }
  | p_2_1=DOUBLE
    { $result = new micro.Absyn.EDbl(Double.parseDouble($p_2_1.getText())); }
  | p_3_1=IDENT
    { $result = new micro.Absyn.EIdn($p_3_1.getText()); }
  | Surrogate_id_SYMB_1 p_4_2=exp Surrogate_id_SYMB_2
    { $result = $p_4_2.result; }
  ;
listIdent returns [ micro.Absyn.ListIdent result ]
  :  /* empty */
    { $result = new micro.Absyn.ListIdent(); }
  | p_2_1=IDENT
    { $result = new micro.Absyn.ListIdent(); $result.addLast($p_2_1.getText()); }
  | p_3_1=IDENT Surrogate_id_SYMB_7 p_3_3=listIdent
    { $result = $p_3_3.result; $result.addFirst($p_3_1.getText()); }
  ;
listExp returns [ micro.Absyn.ListExp result ]
  :  /* empty */
    { $result = new micro.Absyn.ListExp(); }
  | p_2_1=exp
    { $result = new micro.Absyn.ListExp(); $result.addLast($p_2_1.result); }
  | p_3_1=exp Surrogate_id_SYMB_7 p_3_3=listExp
    { $result = $p_3_3.result; $result.addFirst($p_3_1.result); }
  ;
listStm returns [ micro.Absyn.ListStm result ]
  : p_1_1=stm Surrogate_id_SYMB_8
    { $result = new micro.Absyn.ListStm(); $result.addLast($p_1_1.result); }
  | p_2_1=stm Surrogate_id_SYMB_8 p_2_3=listStm
    { $result = $p_2_3.result; $result.addFirst($p_2_1.result); }
  ;
