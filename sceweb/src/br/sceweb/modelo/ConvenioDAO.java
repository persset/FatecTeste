package br.sceweb.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import br.sceweb.servico.FabricaDeConexoes;

public class ConvenioDAO {
	public int adiciona(Convenio Convenio){
		PreparedStatement ps;
		int codigoRetorno=0;
		try (Connection conn = new FabricaDeConexoes().getConnection()) {
			ps = (PreparedStatement) conn.prepareStatement( "insert into Convenio ("
					+ "cnpj, "
					+ "dataInicio, "
					+ "dataTermino, "
					+ "values(?,?,?)");
			ps.setString(1,Convenio.getCnpj());
			//ps.setDate(2, Convenio.getDataInicio());
			//ps.setDate(3, Convenio.getDataFim());
			codigoRetorno = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e); 
		}
		
		return codigoRetorno;

	}
	
	/** * exclui uma Convenio pelo cnpj
	 *  * @param cnpj
	 *  * @return 0 erro na exclusao ou 1 excluido com sucesso
	 *  */ 
		public int exclui (String cnpj) { 
			java.sql.PreparedStatement ps;
			int codigoretorno = 0;
			try (Connection conn = new FabricaDeConexoes().getConnection()) {
				ps= conn.prepareStatement ("delete from Convenio where cnpj = ?");
				ps.setString(1, cnpj); codigoretorno = ps.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return codigoretorno;
		} 

	public Convenio consulta(String cnpj) {
		Convenio convenio = null;
		java.sql.PreparedStatement ps;
		try(Connection conn= new FabricaDeConexoes().getConnection()) {
			ps = conn.prepareStatement("select * from Convenio where cnpj = ?");
			ps.setString(1, cnpj);
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				convenio = new Convenio();
				convenio.setCnpj(resultSet.getString("cnpj"));
				//convenio.setDataFim("dataFim");
				//convenio.setDataInicio("dataInicio");
		} 
		resultSet.close();
		ps.close();
		} 
		catch (SQLException e) { 
			throw new RuntimeException(e);
		}
		return convenio;

	}

}
