package br.laramara.ti.sislaraserver.fabricas;

import java.util.ArrayList;
import java.util.List;

import br.laramara.ti.sislaracommons.dtos.ContatoDTO;
import br.laramara.ti.sislaracommons.dtos.TelefoneDTO;
import br.laramara.ti.sislaracommons.dtos.TipoTelefoneDTO;
import br.laramara.ti.sislaraserver.dominio.Contato;
import br.laramara.ti.sislaraserver.dominio.Telefone;
import br.laramara.ti.sislaraserver.dominio.TipoTelefone;

public class ContextoContato {

	public static Contato fabricarContatoComTodosOsDados() {
		List<Telefone> telefones = new ArrayList<>();
		telefones.add(new Telefone(TipoTelefone.RESIDENCIAL, "1122221111"));
		telefones.add(new Telefone(TipoTelefone.COMERCIAL, "1122221111"));
		telefones.add(new Telefone(TipoTelefone.CELULAR, "1122221111"));

		Contato contato = new Contato();
		contato.setTelefones(telefones);
		contato.setRamal("123123");
		contato.setNomeContato("Josep Meaza Cruz");
		contato.setEmail("paulo@yahoo.com.br");
		return contato;
	}

	public static ContatoDTO construirContatoDTO() {
		List<TelefoneDTO> telefonesDto = new ArrayList<>();
		telefonesDto.add(new TelefoneDTO(new TipoTelefoneDTO("RESIDENCIAL"),
				"1112341234"));
		telefonesDto.add(new TelefoneDTO(new TipoTelefoneDTO("CELULAR"),
				"1112341234"));
		telefonesDto.add(new TelefoneDTO(new TipoTelefoneDTO("COMERCIAL"),
				"1112341234"));

		ContatoDTO contatoDto = new ContatoDTO();
		contatoDto.setTelefonesDto(telefonesDto);
		contatoDto.setRamal("11348");
		contatoDto.setNomeContato("Josep MEaza");
		contatoDto.setEmail("asdasd@adsasd.com");
		return contatoDto;
	}
}
