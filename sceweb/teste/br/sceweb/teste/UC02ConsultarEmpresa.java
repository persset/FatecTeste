package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC02ConsultarEmpresa {
	public static EmpresaDAO empresaDAO;
	public static Empresa empresa;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresa = new Empresa();
		empresaDAO = new EmpresaDAO();
		
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("Casas Bahia S/A");
		empresa.setCnpj("60430951000122");
		empresa.setNomeFantasia("Casas Bahia");
		empresa.setEndereco("Rua Taquari");
		empresa.setTelefone("12344321");

	}
	
	@Before
	public void preCondicao_insereEmpresa() {
		empresaDAO.adiciona(empresa);
	}
	
	@Test
	public void CT01UC02FBConsultar_empresa_com_sucesso() {
		assertTrue(empresa.equals(empresaDAO.consulta("60430951000122")));
	}
	
	/*@Test
	(expected = RuntimeException.class)
	public void CT02UC02ConsultaEmpresa_cnpj_invalido() {
		assertTrue(empresa.equals(empresaDAO.consulta("")));
	}*/
	
	@Test
	public void CT03UC02ConsultarEmpresa_cnpj_não_cadastrado() {
		assertEquals(null, empresaDAO.consulta("60430951000123"));
	}
	
	@After
	public void tearDown() throws Exception {
		//empresaDAO.exclui("60430951000122");
	}

}
