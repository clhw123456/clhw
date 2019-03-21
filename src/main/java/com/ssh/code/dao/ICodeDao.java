package com.ssh.code.dao;

import java.util.List;

import com.ssh.code.entity.Code;
import com.ssh.code.entity.Dict;

public interface ICodeDao {

	List<Code> getCodeList();

	List<Dict> getDictListByType(String type);

	boolean saveCode(Code code);

	Code findCodeByName(String cName);

	boolean updateCode(Code code);

	boolean deleteCode(Integer[] cIds);

}
