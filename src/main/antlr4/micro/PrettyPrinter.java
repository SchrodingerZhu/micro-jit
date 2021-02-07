package micro;

public class PrettyPrinter
{
  //For certain applications increasing the initial size of the buffer may improve performance.
  private static final int INITIAL_BUFFER_SIZE = 128;
  private static final int INDENT_WIDTH = 2;
  //You may wish to change the parentheses used in precedence.
  private static final String _L_PAREN = new String("(");
  private static final String _R_PAREN = new String(")");
  //You may wish to change render
  private static void render(String s)
  {
    if (s.equals("{"))
    {
       buf_.append("\n");
       indent();
       buf_.append(s);
       _n_ = _n_ + INDENT_WIDTH;
       buf_.append("\n");
       indent();
    }
    else if (s.equals("(") || s.equals("["))
       buf_.append(s);
    else if (s.equals(")") || s.equals("]"))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals("}"))
    {
       int t;
       _n_ = _n_ - INDENT_WIDTH;
       for(t=0; t<INDENT_WIDTH; t++) {
         backup();
       }
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals(","))
    {
       backup();
       buf_.append(s);
       buf_.append(" ");
    }
    else if (s.equals(";"))
    {
       backup();
       buf_.append(s);
       buf_.append("\n");
       indent();
    }
    else if (s.equals("")) return;
    else if (s.trim().equals(""))
    {
       backup();
       buf_.append(s);
    }
    else
    {
       buf_.append(s);
       buf_.append(" ");
    }
  }


  //  print and show methods are defined for each category.
  public static String print(micro.Absyn.Prog foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(micro.Absyn.Prog foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(micro.Absyn.Stm foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(micro.Absyn.Stm foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(micro.Absyn.Exp foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(micro.Absyn.Exp foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(micro.Absyn.ListIdent foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(micro.Absyn.ListIdent foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(micro.Absyn.ListExp foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(micro.Absyn.ListExp foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String print(micro.Absyn.ListStm foo)
  {
    pp(foo, 0);
    trim();
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  public static String show(micro.Absyn.ListStm foo)
  {
    sh(foo);
    String temp = buf_.toString();
    buf_.delete(0,buf_.length());
    return temp;
  }
  /***   You shouldn't need to change anything beyond this point.   ***/

  private static void pp(micro.Absyn.Prog foo, int _i_)
  {
    if (foo instanceof micro.Absyn.Program)
    {
       micro.Absyn.Program _program = (micro.Absyn.Program) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("begin");
       pp(_program.liststm_, 0);
       render("end");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(micro.Absyn.Stm foo, int _i_)
  {
    if (foo instanceof micro.Absyn.SAssign)
    {
       micro.Absyn.SAssign _sassign = (micro.Absyn.SAssign) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_sassign.ident_, 0);
       render(":=");
       pp(_sassign.exp_, 0);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof micro.Absyn.SRead)
    {
       micro.Absyn.SRead _sread = (micro.Absyn.SRead) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("read");
       render("(");
       pp(_sread.listident_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof micro.Absyn.SWrite)
    {
       micro.Absyn.SWrite _swrite = (micro.Absyn.SWrite) foo;
       if (_i_ > 0) render(_L_PAREN);
       render("write");
       render("(");
       pp(_swrite.listexp_, 0);
       render(")");
       if (_i_ > 0) render(_R_PAREN);
    }
  }

  private static void pp(micro.Absyn.Exp foo, int _i_)
  {
    if (foo instanceof micro.Absyn.EAdd)
    {
       micro.Absyn.EAdd _eadd = (micro.Absyn.EAdd) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_eadd.exp_1, 0);
       render("+");
       pp(_eadd.exp_2, 1);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof micro.Absyn.ESub)
    {
       micro.Absyn.ESub _esub = (micro.Absyn.ESub) foo;
       if (_i_ > 0) render(_L_PAREN);
       pp(_esub.exp_1, 0);
       render("-");
       pp(_esub.exp_2, 1);
       if (_i_ > 0) render(_R_PAREN);
    }
    else     if (foo instanceof micro.Absyn.EMul)
    {
       micro.Absyn.EMul _emul = (micro.Absyn.EMul) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_emul.exp_1, 1);
       render("*");
       pp(_emul.exp_2, 2);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof micro.Absyn.EDiv)
    {
       micro.Absyn.EDiv _ediv = (micro.Absyn.EDiv) foo;
       if (_i_ > 1) render(_L_PAREN);
       pp(_ediv.exp_1, 1);
       render("/");
       pp(_ediv.exp_2, 2);
       if (_i_ > 1) render(_R_PAREN);
    }
    else     if (foo instanceof micro.Absyn.EInt)
    {
       micro.Absyn.EInt _eint = (micro.Absyn.EInt) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_eint.integer_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof micro.Absyn.EDbl)
    {
       micro.Absyn.EDbl _edbl = (micro.Absyn.EDbl) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_edbl.double_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
    else     if (foo instanceof micro.Absyn.EIdn)
    {
       micro.Absyn.EIdn _eidn = (micro.Absyn.EIdn) foo;
       if (_i_ > 2) render(_L_PAREN);
       pp(_eidn.ident_, 0);
       if (_i_ > 2) render(_R_PAREN);
    }
  }

  private static void pp(micro.Absyn.ListIdent foo, int _i_)
  {
     for (java.util.Iterator<String> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }  }

  private static void pp(micro.Absyn.ListExp foo, int _i_)
  {
     for (java.util.Iterator<micro.Absyn.Exp> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(",");
       } else {
         render("");
       }
     }  }

  private static void pp(micro.Absyn.ListStm foo, int _i_)
  {
     for (java.util.Iterator<micro.Absyn.Stm> it = foo.iterator(); it.hasNext();)
     {
       pp(it.next(), _i_);
       if (it.hasNext()) {
         render(";");
       } else {
         render("");
       }
     }  }


  private static void sh(micro.Absyn.Prog foo)
  {
    if (foo instanceof micro.Absyn.Program)
    {
       micro.Absyn.Program _program = (micro.Absyn.Program) foo;
       render("(");
       render("Program");
       render("[");
       sh(_program.liststm_);
       render("]");
       render(")");
    }
  }

  private static void sh(micro.Absyn.Stm foo)
  {
    if (foo instanceof micro.Absyn.SAssign)
    {
       micro.Absyn.SAssign _sassign = (micro.Absyn.SAssign) foo;
       render("(");
       render("SAssign");
       sh(_sassign.ident_);
       sh(_sassign.exp_);
       render(")");
    }
    if (foo instanceof micro.Absyn.SRead)
    {
       micro.Absyn.SRead _sread = (micro.Absyn.SRead) foo;
       render("(");
       render("SRead");
       render("[");
       sh(_sread.listident_);
       render("]");
       render(")");
    }
    if (foo instanceof micro.Absyn.SWrite)
    {
       micro.Absyn.SWrite _swrite = (micro.Absyn.SWrite) foo;
       render("(");
       render("SWrite");
       render("[");
       sh(_swrite.listexp_);
       render("]");
       render(")");
    }
  }

  private static void sh(micro.Absyn.Exp foo)
  {
    if (foo instanceof micro.Absyn.EAdd)
    {
       micro.Absyn.EAdd _eadd = (micro.Absyn.EAdd) foo;
       render("(");
       render("EAdd");
       sh(_eadd.exp_1);
       sh(_eadd.exp_2);
       render(")");
    }
    if (foo instanceof micro.Absyn.ESub)
    {
       micro.Absyn.ESub _esub = (micro.Absyn.ESub) foo;
       render("(");
       render("ESub");
       sh(_esub.exp_1);
       sh(_esub.exp_2);
       render(")");
    }
    if (foo instanceof micro.Absyn.EMul)
    {
       micro.Absyn.EMul _emul = (micro.Absyn.EMul) foo;
       render("(");
       render("EMul");
       sh(_emul.exp_1);
       sh(_emul.exp_2);
       render(")");
    }
    if (foo instanceof micro.Absyn.EDiv)
    {
       micro.Absyn.EDiv _ediv = (micro.Absyn.EDiv) foo;
       render("(");
       render("EDiv");
       sh(_ediv.exp_1);
       sh(_ediv.exp_2);
       render(")");
    }
    if (foo instanceof micro.Absyn.EInt)
    {
       micro.Absyn.EInt _eint = (micro.Absyn.EInt) foo;
       render("(");
       render("EInt");
       sh(_eint.integer_);
       render(")");
    }
    if (foo instanceof micro.Absyn.EDbl)
    {
       micro.Absyn.EDbl _edbl = (micro.Absyn.EDbl) foo;
       render("(");
       render("EDbl");
       sh(_edbl.double_);
       render(")");
    }
    if (foo instanceof micro.Absyn.EIdn)
    {
       micro.Absyn.EIdn _eidn = (micro.Absyn.EIdn) foo;
       render("(");
       render("EIdn");
       sh(_eidn.ident_);
       render(")");
    }
  }

  private static void sh(micro.Absyn.ListIdent foo)
  {
     for (java.util.Iterator<String> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(micro.Absyn.ListExp foo)
  {
     for (java.util.Iterator<micro.Absyn.Exp> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }

  private static void sh(micro.Absyn.ListStm foo)
  {
     for (java.util.Iterator<micro.Absyn.Stm> it = foo.iterator(); it.hasNext();)
     {
       sh(it.next());
       if (it.hasNext())
         render(",");
     }
  }


  private static void pp(Integer n, int _i_) { buf_.append(n); buf_.append(" "); }
  private static void pp(Double d, int _i_) { buf_.append(String.format(java.util.Locale.ROOT, "%.15g ", d)); }
  private static void pp(String s, int _i_) { buf_.append(s); buf_.append(" "); }
  private static void pp(Character c, int _i_) { buf_.append("'" + c.toString() + "'"); buf_.append(" "); }
  private static void sh(Integer n) { render(n.toString()); }
  private static void sh(Double d) { render(String.format(java.util.Locale.ROOT, "%.15g", d)); }
  private static void sh(Character c) { render("'" + c.toString() + "'"); }
  private static void sh(String s) { printQuoted(s); }
  private static void printQuoted(String s) { render("\"" + s + "\""); }
  private static void indent()
  {
    int n = _n_;
    while (n > 0)
    {
      buf_.append(' ');
      n--;
    }
  }
  private static void backup()
  {
    int prev = buf_.length() - 1;
    if (buf_.charAt(prev) == ' ')
      buf_.setLength(prev);
  }
  private static void trim()
  {
    // Trim initial spaces
    int end = 0;
    int len = buf_.length();
    while (end < len && buf_.charAt(end) == ' ')
      end++;
    buf_.delete(0, end);
    // Trim trailing spaces
    end = buf_.length();
    while (end > 0 && buf_.charAt(end-1) == ' ')
      end--;
    buf_.setLength(end);
  }
  private static int _n_ = 0;
  private static StringBuilder buf_ = new StringBuilder(INITIAL_BUFFER_SIZE);
}

