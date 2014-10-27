package br.com.jarves.bancodedados;

import br.com.jarves.classes.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FornecedorDAO {
        
    
    public Fornecedor getCliente(Fornecedor fornecedor, int IdEndereco){
                
        ConexaoOracle co = new ConexaoOracle();
        Logradouro endereco = new Logradouro();
        try {
            
            Connection con = co.abreConexao();
            String sql = "SELECT c.id_cliente, initcap(c.nome_cliente)nome_cliente"+
                    " ,l.id_logradouro,l.nome_logradouro, l.cep_logradouro, "+
                    "b.nome_bairro, m.nome_municipio,e.nome_estado "+
                    "FROM tab_cliente c INNER JOIN tab_logradouro l "+
                    "ON c.id_logradouro in l.id_logradouro "+
                    "INNER JOIN  tab_bairro b ON l.id_bairro in b.id_bairro INNER JOIN tab_municipio m ON "+ 
                    "b.id_municipio in m.id_municipio INNER JOIN tab_estado e ON m.id_estado IN e.id_estado "+
                    "WHERE c.nome_cliente in ? or c.id_cliente in ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, fornecedor.getNomeFornecedor());
            stmt.setInt(2, fornecedor.getIdFornecedor());
            ResultSet rs = stmt.executeQuery();
            System.out.println(sql);
            if(rs.next()){
                fornecedor.setIdFornecedor(rs.getInt("id_fornecedor"));
                fornecedor.setNomeFornecedor(rs.getString("nome_fornecedor"));
                endereco.setNomeRua(rs.getString("nome_logradouro"));
                endereco.setBairro(rs.getString("nome_bairro"));
                endereco.setCep(rs.getString("cep_logradouro"));
                endereco.setCidade(rs.getString("nome_municipio"));
                endereco.setEstado(rs.getString("nome_estado"));
                fornecedor.setIdEndereco(endereco);
            }else{
                fornecedor = null;
            }
            co.fecharConexao(rs, stmt, con);
        } catch (SQLException | NullPointerException ex) {
            JOptionPane.showMessageDialog(null,"Erro: " + ex);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro: " + e);
            e.printStackTrace();
        }
        //JOptionPane.showMessageDialog(null, user.getNomeUsuario());
        return fornecedor;
    }
    
    /**
     * Insere um cliente no banco de dados
     * @param fornecedor dados do cliente
     * @return Mensagem
     */
    public String insereFornecedor(Fornecedor fornecedor){
        String msg = null;
        ConexaoOracle co = new ConexaoOracle();
        
        try {
            
            Connection con = co.abreConexao();
            CallableStatement cs = con.prepareCall("{call insere_cliente(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, fornecedor.getNomeFornecedor());
            cs.setString(2, fornecedor.getCnpj());
          
            cs.execute();
            cs.close();
            con.close();
            msg = "Fornecedor Cadastrado com Sucesso";
            
        } catch (SQLException ex) {
            msg = "Erro"+ex;
        }

        return msg;
    }
    /**
     * Método que pesquisa se o cliente já é cadastrado
     * @param cpf cpf do cliente
     * @param nome nome do cliente
     * @return ArrayList de clientes 
     */
    public ArrayList<Fornecedor> pesquisarFornecedor(String cnpj,String nome){
       
        ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();
        ConexaoOracle co = new ConexaoOracle();
        try {
            Connection con = co.abreConexao();
            String sql = "SELECT id_fornecedor,initcap(nome_cliente)nome,cpf_cliente cpf,rg_cliente rg, dtnasc_cliente nasc,initcap(sexo_cliente)sexo," +
                         "dtcad_cliente dtcad,initcap(tl.nome_logradouro)endereco,tl.cep_logradouro cep,te.nr_endereco num, "+
                         "te.comp_endereco,tcon.email_contato email,tcon.cel_contato celu,tcon.tel_contato tele,tcon.obs_contato,initcap(tba.nome_bairro)bairro,"+
                         "initcap(tmu.nome_municipio)cidade,initcap(tes.nome_estado) estado FROM "+
                         "tab_cliente tc INNER JOIN tab_endereco te ON tc.id_cliente IN te.id_cliente_fk INNER JOIN tab_logradouro tl ON "+
                         "te.id_logradouro_fk IN tl.id_logradouro INNER JOIN "+
                         "tab_contato tcon ON tc.id_cliente IN tcon.id_cliente_fk INNER JOIN tab_bairro tba ON "+
                         "tl.id_bairro IN tba.id_bairro INN_endereco,tcon.email_contato email,tcon.cel_contato celu,tcon.tel_contato tele,tcon.obs_contato,initcap(tba.nome_bairro)bairro,\"+\n" +
"                         \"initcap(tmu.nome_municipio)cidade,initcap(tes.nome_estado) estado FROM \"+\n" +
"                         \"tab_cliente tc INNER JOIN tab_endereco te ON tc.id_cliente IN te.id_cliente_fk INNER JOIN tab_logradouro tl ON \"+\n" +
"                         \"te.id_logradouro_fk IN tl.id_logradouro INNER JOIN \"+\n" +
"                         \"tab_contato tcon ON tc.id_cliente IN tcon.id_clieER JOIN tab_municipio tmu ON "+
                         "tba.id_municipio IN tmu.id_municipio INNER JOIN tab_estado tes ON "+
                         "tmu.id_estado IN tes.id_estado WHERE tc.nome_cliente LIKE ? or tc.cpf_cliente like ?";
            System.out.println(sql + nome + cnpj);
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, cnpj);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Fornecedor fornecedor =  new Fornecedor();
                Logradouro endereco = new Logradouro();
                Contato contato = new Contato();
                
                fornecedor.setIdFornecedor(rs.getInt(""));
                fornecedor.setNomeFornecedor(rs.getString("nome"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setIeFornecedor(rs.getString("inscricao estadual"));
                fornecedor.setDtCadFornecedor(rs.getDate("dtcad"));
                endereco.setNomeRua(rs.getString("endereco"));
                endereco.setNumero(rs.getString("num"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCidade(rs.getString("cidade"));
                endereco.setEstado(rs.getString("estado"));
                endereco.setComplemento(rs.getString("comp_endereco"));
                endereco.setCep(rs.getString("cep"));
                contato.setEmail(rs.getString("email"));
                contato.setCelular(rs.getString("celu"));
                contato.setTelefone(rs.getString("tele"));
                contato.setObs(rs.getString("obs_contato"));
                fornecedor.setIdEndereco(endereco);
                fornecedor.setIdContato(contato);
                lista.add(fornecedor);
            }
            co.fecharConexao(rs, stmt, con);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: " + ex);
        }
        
        return lista;
         
    }
    /**
     * Método que lista todos os clientes já cadastrados
     * @return  ArrayList de clientes
     */
    public ArrayList<Fornecedor> listarFornecedor(){
       
        ArrayList<Fornecedor> lista = new ArrayList<Fornecedor>();
        ConexaoOracle co = new ConexaoOracle();
        try {
            Connection con = co.abreConexao();
            String sql = "SELECT id_cliente,initcap(nome_cliente)nome,cpf_cliente cpf,rg_cliente rg, dtnasc_cliente nasc,initcap(sexo_cliente)sexo,"+
                         "dtcad_cliente dtcad,initcap(tl.nome_logradouro)endereco,tl.cep_logradouro cep,te.nr_endereco num, te.comp_endereco,"+
                         "tcon.email_contato email,tcon.cel_contato celu,tcon.tel_contato tele,tcon.obs_contato "+
                         "FROM tab_cliente tc INNER JOIN tab_endereco te ON tc.id_cliente IN te.id_cliente_fk INNER JOIN tab_logradouro tl ON "+
                         "te.id_logradouro_fk IN tl.id_logradouro INNER JOIN tab_contato tcon ON "+
                         "tc.id_cliente in tcon.id_cliente_fk ";
            System.out.println(sql);
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Fornecedor fornecedor =  new Fornecedor();
                Logradouro endereco = new Logradouro();
                Contato contato = new Contato();
                
                fornecedor.setIdFornecedor(rs.getInt(""));
                fornecedor.setNomeFornecedor(rs.getString("nome"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setIeFornecedor(rs.getString("inscricao estadual"));
                fornecedor.setDtCadFornecedor(rs.getDate("dtcad"));
                endereco.setNomeRua(rs.getString("endereco"));
                endereco.setNumero(rs.getString("num"));
                endereco.setComplemento(rs.getString("comp_endereco"));
                endereco.setCep(rs.getString("cep"));
                contato.setEmail(rs.getString("email"));
                contato.setCelular(rs.getString("celu"));
                contato.setTelefone(rs.getString("tele"));
                contato.setObs(rs.getString("obs_contato"));
                fornecedor.setIdEndereco(endereco);
                fornecedor.setIdContato(contato);
                lista.add(fornecedor);
            }
            co.fecharConexao(rs, stmt, con);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro: " + ex);
        }
        
        return lista;
         
    }

}
