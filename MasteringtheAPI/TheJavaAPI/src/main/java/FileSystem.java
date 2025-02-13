/*   -Checking File Accessibility

Path file = ...;
boolean isRegularExecutableFile = Files.isRegularFile(file) &
Files.isReadable(file) & Files.isExecutable(file);


-Deleting a File or Directory
try {
    Files.delete(path);
} catch (NoSuchFileException x) {
    System.err.format("%s: no such" + " file or directory%n", path);
} catch (DirectoryNotEmptyException x) {
    System.err.format("%s not empty%n", path);
} catch (IOException x) {
    // File permission problems are caught here.
    System.err.println(x);
}

-Copying a File or Directory
import static java.nio.file.StandardCopyOption.*;

Files.copy(source, target, REPLACE_EXISTING);


-Moving a File or Directory
           -Using Varargs:
Path Files.move(Path, Path, CopyOption...)

           -Moving Directories:
import static java.nio.file.StandardCopyOption.*;
Files.move(source, target, REPLACE_EXISTING);



-Creating a Symbolic Link
Path newLink = ...;
Path target = ...;
try {
    Files.createSymbolicLink(newLink, target);
} catch (IOException x) {
    System.err.println(x);
} catch (UnsupportedOperationException x) {
    // Some file systems do not support symbolic links.
    System.err.println(x);
}


-Creating a Hard Link
Path newLink = ...;
Path existingFile = ...;
try {
    Files.createLink(newLink, existingFile);
} catch (IOException x) {
    System.err.println(x);
} catch (UnsupportedOperationException x) {
    // Some file systems do not
    // support adding an existing
    // file to a directory.
    System.err.println(x);
}



-Detecting a Symbolic Link
Path file = ...;
boolean isSymbolicLink =
    Files.isSymbolicLink(file);



-Finding the Target of a Link
Path link = ...;
try {
    System.out.format("Target of link" +
        " '%s' is '%s'%n", link,
        Files.readSymbolicLink(link));
} catch (IOException x) {
    System.err.println(x);
}




 */

