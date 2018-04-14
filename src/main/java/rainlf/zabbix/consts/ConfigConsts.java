package rainlf.zabbix.consts;

import java.util.Arrays;
import java.util.List;

public class ConfigConsts {

    private static final List<String> zabbixItems = Arrays.asList("net.if.in[ens160]", "net.if.out[ens160]", "proc.num[,,run]", "proc.num[]", "system.cpu.intr", "system.cpu.load[percpu,avg1]", "system.cpu.load[percpu,avg15]", "system.cpu.load[percpu,avg5]", "system.cpu.switches", "system.cpu.util[,idle]", "system.cpu.util[,interrupt]", "system.cpu.util[,iowait]", "system.cpu.util[,nice]", "system.cpu.util[,softirq]", "system.cpu.util[,steal]", "system.cpu.util[,system]", "system.cpu.util[,user]", "system.swap.size[,free]", "system.swap.size[,pfree]", "system.swap.size[,total]", "vfs.fs.inode[/,pfree]", "vfs.fs.inode[/boot,pfree]", "vfs.fs.inode[/var/lib/docker/aufs,pfree]", "vfs.fs.inode[/var/lib/kubelet,pfree]", "vfs.fs.inode[/var/lib/rancher/volumes,pfree]", "vfs.fs.size[/,pfree]", "vfs.fs.size[/,total]", "vfs.fs.size[/,used]", "vfs.fs.size[/boot,free]", "vfs.fs.size[/boot,pfree]", "vfs.fs.size[/boot,total]", "vfs.fs.size[/boot,used]", "vfs.fs.size[/var/lib/docker/aufs,pfree]", "vfs.fs.size[/var/lib/docker/aufs,total]", "vfs.fs.size[/var/lib/docker/aufs,used]", "vfs.fs.size[/var/lib/kubelet,free]", "vfs.fs.size[/var/lib/kubelet,pfree]", "vfs.fs.size[/var/lib/kubelet,total]", "vfs.fs.size[/var/lib/kubelet,used]", "vfs.fs.size[/var/lib/rancher/volumes,free]", "vfs.fs.size[/var/lib/rancher/volumes,pfree]", "vfs.fs.size[/var/lib/rancher/volumes,total]", "vfs.fs.size[/var/lib/rancher/volumes,used]", "vm.memory.size[available]", "vm.memory.size[total]");

    public static List<String> getZabbixItems() {
        return zabbixItems;
    }
}
