package lotto.collections;

import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.LottoNumber;

public class LottoTicket {

	protected final List<LottoNumber> lottoNumbers;

	public LottoTicket(List<LottoNumber> lottoNumbers) {
		this.lottoNumbers = lottoNumbers;
	}

	public List<LottoNumber> getLottoNumbers() {
		return lottoNumbers;
	}

	public boolean contains(LottoNumber lottoNumber) {
		return lottoNumbers.stream()
			.anyMatch(number -> number.getNumber().equals(lottoNumber.getNumber()));
	}

	public int getMatchCount(LottoNumber winningNumber) {
		return (int) this.lottoNumbers.stream()
			.filter(number -> winningNumber.getNumber().equals(number.getNumber()))
			.count();
	}

	@Override
	public String toString() {
		return "[" + lottoNumbers.stream()
			.map(Object::toString)
			.collect(Collectors.joining(", ")) + ']';
	}
}
