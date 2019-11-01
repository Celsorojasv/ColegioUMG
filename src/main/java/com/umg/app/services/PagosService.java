package com.umg.app.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umg.app.models.entity.Estudiante;
import com.umg.app.models.entity.Pagos;

@Service
public class PagosService implements IPago {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = true)
	@Override
	public List<Pagos> findAllByStudent(Long id) {

		String sql = "SELECT e.id_estudiante, e.nom_es1, e.ape_es1, p.id_pago , p.monto_pago "
				+ " , p.fecha_pago , p.descripcion_pago  FROM pagos p INNER JOIN estudiantes e WHERE e.id_estudiante  = ? ";

		return jdbcTemplate.query(sql, new Object[] {id} , new RowMapper<Pagos>() {
			@Override
			public Pagos mapRow(ResultSet rs, int rowNum) throws SQLException {
				Estudiante es = new Estudiante();
				Pagos pa = new Pagos();

				pa.setIdPago(rs.getFloat("id_pago"));
				pa.setMontoPago(rs.getFloat("monto_pago"));
				pa.setFechaPago(rs.getString("fecha_pago"));
				pa.setDescrPago(rs.getString("descripcion_pago"));

				es.setIdEstu(rs.getLong("id_estudiante"));
				es.setNombreEstu1(rs.getString("nom_es1"));
				es.setApeEstu1(rs.getString("ape_es1"));
				
				pa.setEstudiante(es);

				return pa;
			}
		}

		);
	}

	@Override
	public void save(Pagos pagos) {
		String sql = "INSERT INTO pagos " + "(id_pago , monto_pago , fecha_pago , descripcion_pago , id_estudiante) " +
				"VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sql, new Object[] {pagos.getIdPago() , pagos.getMontoPago() , pagos.getFechaPago() , pagos.getDescrPago() , pagos.getEstudiante()});
	}

}
