<?php $file = 'index.html';
if (isset($_GET['file'])) { $file = $_GET['file']; }

if (preg_match('/\.[^\/]+$/', $file)) {
	if (preg_match('/\.(png|jpg|gif)$/i', $file)) {
		$remoteImage = $file;
		$imginfo = getimagesize($remoteImage);
		header("Content-type: ".$imginfo['mime']);
		readfile($remoteImage);
	} else {
		echo file_get_contents($file);
		
	}
} else {
	$dir = scandir($file);
	$file = trim($file, '/');
	$prev = dirname($file);
	echo "<a href='getfiles.php?file=$prev/'>&larr; Back</a><br>";
	for ($i = 0; $i < count($dir);$i++) {
		if (preg_match('/\.[^\/]+$/', $dir[$i])) {
			echo "$i. <a href='getfiles.php?file=$file/$dir[$i]'>$dir[$i]</a><br>";
		} else {
			echo "$i. <a href='getfiles.php?file=$file/$dir[$i]/'>$dir[$i]</a><br>";
		}
	}
}?>