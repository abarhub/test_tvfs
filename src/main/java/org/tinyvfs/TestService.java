package org.tinyvfs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tinyvfs.config.TVFSConfigParam;
import org.tinyvfs.config.TVFSRepository;
import org.tinyvfs.path.TVFSRootName;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Alain on 01/01/2017.
 */
public class TestService {

	final static Logger LOGGER = LoggerFactory.getLogger(TestService.class);

	public static void main(String arg[]) throws Exception {

		//test1();
		//test2();
		test3();
	}

	private static void test1() {
		LOGGER.info("create URI");
		URI uri = URI.create("tvfs://$test1");
		LOGGER.info("uri=" + uri);
		LOGGER.info("create FS");
		FileSystem fs = FileSystems.getFileSystem(uri);
		LOGGER.info("fs=" + fs);
	}

	private static void test2() throws IOException {
		LOGGER.info("create URI");
		URI uri = URI.create("tvfs://$test1");
		LOGGER.info("uri=" + uri);
		LOGGER.info("create FS");
		FileSystem fs = FileSystems.newFileSystem(uri, null);
		LOGGER.info("fs=" + fs);
	}

	private static void test3() throws IOException {
		LOGGER.info("add config");
		TVFSConfigParam conf=new TVFSConfigParam(new TVFSRootName("test1"),Paths.get("c:/test"),false);
		TVFSRepository.getInstance().add(conf.getName(),conf);
		LOGGER.info("create URI");
		URI uri = URI.create("tvfs://$test1/abc/def");
		LOGGER.info("uri=" + uri);
		LOGGER.info("create FS");
		Path path = Paths.get(uri);
		LOGGER.info("path=" + path);
	}
}
