package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC01CadastrarEmpresa {
	public static EmpresaDAO empresaDAO;
	public static Empresa empresa;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresa = new Empresa();
		empresaDAO = new EmpresaDAO();
		
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");

	}
	
	@After
	public void excluiEmpresa() throws Exception {
		empresaDAO.exclui("89424232000180");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void CT01UC01FB_cadastrar_empresa_com_sucesso() {
		assertEquals(1, empresaDAO.adiciona(empresa));
	}
	
	@Test
	public void CT02UC01A2Cadastra_empresa_cnpj_ja_cadastrado() throws RuntimeException {
		empresa.setCnpj("89424232000180");
	}
	
	@Test
	public void CT02UC01A2Cadastra_empresa_cnpj_invalido() throws IllegalArgumentException {
		empresa.setCnpj("89424232000180");
	}
	
	@Test
	public void CT03UC01A2Cadastra_empresa_com_dados_invalidos() throws Exception {
		
	}

	@Test
	(expected=IllegalArgumentException.class)
	public void CT04UC01A2Cadastra_empresa_nomeEmpresa_invalido() {
		empresa.setNomeDaEmpresa("");
	}
	
	@Test
	(expected=IllegalArgumentException.class)
	public void CT04UC01A2Cadastra_empresa_nomeFantasia_invalido() {
		empresa.setNomeFantasia("");
	}
	
	@Test
	(expected=IllegalArgumentException.class)
	public void CT04UC01A2Cadastra_empresa_endereco_invalido() {
		empresa.setEndereco("");
	}
	
	@Test
	(expected=IllegalArgumentException.class)
	public void CT04UC01A2Cadastra_empresa_telefone_invalido() {
		empresa.setTelefone("");
	}
}
