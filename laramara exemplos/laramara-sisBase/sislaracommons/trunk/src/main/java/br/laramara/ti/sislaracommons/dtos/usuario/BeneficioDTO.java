package br.laramara.ti.sislaracommons.dtos.usuario;

import br.laramara.ti.sislaracommons.dtos.ModeloDTO;

public class BeneficioDTO extends ModeloDTO {

	private static final long serialVersionUID = 3601434085370605479L;

	private Long id;
	private String descricao;

	public BeneficioDTO(Long id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return descricao;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeneficioDTO other = (BeneficioDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
