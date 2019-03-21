package com.ssh.code.service;

import java.util.List;

import com.ssh.code.entity.Code;
import com.ssh.code.entity.Dict;
import com.ssh.code.view.R;

public interface ICodeService {

	List<Code> getCodeList();

	List<Dict> getDictListByType(String type);

	R saveCode(Code code);

	R updateCode(Code code);

	R deleteCode(Integer[] cIds);

}
